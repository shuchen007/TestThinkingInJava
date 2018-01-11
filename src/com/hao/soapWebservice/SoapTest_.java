package com.hao.soapWebservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SoapTest_ {

//    public void testPost(String urlStr,String data) {
//        try {
////创建指定链接的url对象
//            URL url = new URL(urlStr);
////建立到url对象之间的链接
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
////如果打算使用 URL 连接进行输出，则将 DoOutput 标志设置为 true
//            con.setDoOutput(true);
////设置第一次请求的数据内容不被存储
//            con.setRequestProperty("Pragma:", "no-cache");
////设置请求的数据内容不被存储
//            con.setRequestProperty("Cache-Control", "no-cache");
////设置请求的字符集编码格式,如果不指定，则默认采用16进制的字符集编码格式
//            con.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
////构造向指定链接写入数据的的输出流
//            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
////获取xml数据
//            String xmlInfo = getXmlInfo(data);
////向指定链接写入数据
//            out.write(new String(xmlInfo));
//            out.flush();
//            out.close();
////将从服务端返回的数据读取到内存中
//            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String line = "";
////构造一个空的StringBuffer对象，用于存储内存中的数据
//            StringBuffer buf = new StringBuffer();
//            for (line = br.readLine(); line != null; line = br.readLine()) {
////由于服务端返回的数据的字符集编码有可能不是utf-8,需要对返回的数据通过指定的字符集进行解码
//                buf.append(new String(line.getBytes(),"UTF-8"));
//            }
//
////获取服务端返回的HttpCode
//            int httpCode = con.getResponseCode();
//            System.out.println("HttpCode:"+httpCode+"  "+map.get("msgType")+"接口:"+buf.toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    //处理xml数据
//    public static String getXmlInfo(String data){
////对webservice接口进行加密(SHA-1加密)
//        SoapKey soapKey = new SoapKey();
//        String key=soapKey.getMessageDigest(data, "SHA-1");
////处理传输数据的"<"与">"字符
//        String str = new String(data.replace("<","&lt;")).replace(">","&gt;");
//        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.ws.gpo.yy.com/\">"+"<soapenv:Header/>"
//                +"<soapenv:Body><ser:sendRecv4Supplier><!--Optional:--><sUser>zhuwei</sUser><!--Optional:--><sPwd>password</sPwd><!--Optional:--><sJgbm>GYSNB001</sJgbm><!--Optional:--><sVersion>1.0.0.0</sVersion><!--Optional:--><sXxlx>GS102</sXxlx><!--Optional:--><sSign>"+key+"</sSign><!--Optional:-->"
//                +"<xmlData>"+str+"</xmlData>"
//                +"</ser:sendRecv4Supplier></soapenv:Body></soapenv:Envelope>";
//        return xml;
//    }
//
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String url = "http://192.168.1.208:8090/gpodec/webservice/supplierService";
//        new SoapTest().testPost(url);
//    }
}
