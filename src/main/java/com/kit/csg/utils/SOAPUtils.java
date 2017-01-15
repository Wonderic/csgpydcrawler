package com.kit.csg.utils;

import org.w3c.dom.Document;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Map;

/**
 * Created by furthers on 2016/12/15.
 */
public class SOAPUtils {
    //    private static String ns="http://axisversion.sample";
//    private static String wsdlUrl="http://127.0.0.1:8080/axis2/services/Version?wsdl";
    //        String ns="http://axisversion.sample";
    private static String wsdlUrl="http://127.0.0.1:8080/axis2/services/Version?wsdl";
    private static String namespace="";
    private static String method = "";
    private static String prefix = "";
    public static boolean send(Map params) {

        URL url = null;
        try {
            url = new URL(wsdlUrl);
            QName sname = new QName(namespace, method);
            Service service = Service.create(url, sname);

            Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(namespace, method), SOAPMessage.class, Service.Mode.MESSAGE);

            SOAPMessage msg = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();

            SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
            SOAPBody body = envelope.getBody();

            QName ename = new QName(namespace, method, prefix);
            SOAPBodyElement element = body.addBodyElement(ename);

//            element.addChildElement("data").setValue(Utils.encodeBase64(params.get("data").toString().getBytes()));
//            element.addChildElement("b").setValue("");
            params.forEach((k, v) -> {
                try {
                    element.addChildElement(k.toString()).setValue(Utils.encodeBase64(v.toString().getBytes()));
                } catch (SOAPException sop) {
                    sop.printStackTrace();
                }
            });
            msg.writeTo(System.out);
            System.out.println("\n invoking.....");

            SOAPMessage response = dispatch.invoke(msg);
            response.writeTo(System.out);
            System.out.println();

            Document document = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
            String str = document.getElementsByTagName("ns:return").item(0).getTextContent();
            System.out.println(str);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
