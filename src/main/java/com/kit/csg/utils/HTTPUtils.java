package com.kit.csg.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPUtils {
    static Logger logger = Logger.getLogger("下载器");

    static public Long TIMEOUT = 1L * 60 * 1000;
    public static final int cache = 10 * 1024;

    public static final AtomicBoolean isWindows;
    public static final AtomicReference<String> splash;
    public static final AtomicReference<String> root;
    public static final AtomicInteger DOWNLOUADCOUNT = new AtomicInteger(3);

    private static final AtomicReference<Integer> connectionRequestTimeout = new AtomicReference<>(3000);
    private static final AtomicReference<Integer> socketTimeOut = new AtomicReference<>(3000);
    private static final AtomicReference<Integer> connectTimeout = new AtomicReference<>(3000);

    static {
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().contains("windows")) {
            isWindows = new AtomicBoolean(true);
            splash = new AtomicReference<>("\\");
            root = new AtomicReference<>(System.getProperty("java.io.tmpdir"));
        } else {
            isWindows = new AtomicBoolean(false);
            splash = new AtomicReference<>("/");
            root = new AtomicReference<>(System.getProperty("java.io.tmpdir"));
        }
    }

    public static String get(String urlStr){
        StringBuffer jsonStr=new StringBuffer();
        BufferedReader bufferedReader=null;
        try {
            URL url=new URL(urlStr);
            URLConnection connection=url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input=null;
            while ((input=bufferedReader.readLine())!=null){
                jsonStr.append(input);
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try {
                if (null!=bufferedReader){
                    bufferedReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return jsonStr.toString();
    }

    public static String HttpGetJson(String url) throws InterruptedException, IOException {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout.get()).setConnectTimeout(connectTimeout.get())
                .setSocketTimeout(socketTimeOut.get()).build();
        int count = 0;
        Boolean downFinish = false;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet;
        CloseableHttpResponse response = null;
        while (count < DOWNLOUADCOUNT.get() && !downFinish) {
            try {
                httpGet = new HttpGet(url);
                httpGet.setConfig(requestConfig);
                response = httpclient.execute(httpGet);
                downFinish= true;
            } catch (ConnectException e) {
                Thread.sleep(TIMEOUT);
                logger.log(Level.SEVERE, "1分钟后重新下载,错误次数:" + count++);
            }
            catch (UnknownHostException e){
                Thread.sleep(TIMEOUT);
                logger.log(Level.SEVERE, "1分钟后重新下载,错误次数:" + count++);
            }
            catch(ConnectTimeoutException e){
                Thread.sleep(TIMEOUT);
                logger.log(Level.SEVERE, "1分钟后重新下载,错误次数:" + count++);
            }
            catch (SocketTimeoutException e){
                Thread.sleep(TIMEOUT);
                logger.log(Level.SEVERE, "1分钟后重新下载,错误次数:" + count++);
            }
            catch (Exception e){
                e.printStackTrace();
                Thread.sleep(TIMEOUT);
                logger.log(Level.SEVERE, "1分钟后重新下载,错误次数:" + count++);
            }
            if (downFinish && count >= DOWNLOUADCOUNT.get()) {
                Thread.sleep(TIMEOUT);
                throw new ConnectTimeoutException("重复三次下载失败,退出下载程序");
            }
        }
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.OK.value()) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } else if(statusCode ==HttpStatus.NOT_FOUND.value()){
                throw new FileNotFoundException("[" + statusCode + "].地址为:" + url);
            }
            else{
                Thread.sleep(TIMEOUT);
                throw new FileNotFoundException("[" + statusCode + "].地址为:" + url);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public static HtmlPage htmlSave(String url) throws IOException
    {

        final WebClient webClient=new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        final HtmlPage page=webClient.getPage(url);
        webClient.close();
        return page;
    }

    /**
     * 获取网页HTML源代码
     *
     * @param url
     * @return
     * @throws ParseException
     * @throws IOException
     */

    public static String getHtml(String url)  {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try{
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpclient.execute(get);
            try{
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity,"UTF-8");
            } finally{
                httpResponse.close();
            }
        }catch(HttpHostConnectException e) {
            System.out.println("****"+url+"****");
            try {
                httpclient.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null;
        }catch(ParseException e)
        {
            e.printStackTrace();
            try {
                httpclient.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null;
        }catch(IOException e)
        {
            e.printStackTrace();
            try {
                httpclient.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null;
        }
        finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
