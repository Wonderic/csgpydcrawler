package com.kit.csg.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by huanm on 2016/12/6.
 */
public class HTTPUtils {
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
}
