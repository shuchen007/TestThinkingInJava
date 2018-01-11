package com.hao.soapWebservice;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;


public class TestSoap_get_post {

    public String test(String text) throws IOException {
        // TODO Auto-generated method stub
        String url = "http://www.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx/toTraditionalChinese";
//        String url = "http://localhost:8080/web-app/";
//        String host = "www.webxml.com.cn";
//        URLEncoder.encode(text,"utf-8");
        String param = "sText="+ URLEncoder.encode(text, "utf-8");
//        String param = "name="+ URLEncoder.encode(text, "utf-8");
//        String param = "sText=%e6%89%93%e9%a3%9e%e6%9c%ba";

        HttpClient httpClient = new HttpClient();
//        httpClient.getHostConfiguration().setHost(host, 80, "http");

        HttpMethod method = getMethod(url, param);
//        HttpMethod method = postMethod(url);

        System.out.println("Method="+method);
        int statusCode = httpClient.executeMethod(method);
        System.out.println("statusCode="+statusCode);
        if (statusCode == 200) {
            int count = 0;
            System.out.println("调用成功！");
            String soapResponseData = method.getResponseBodyAsString();
            System.out.println("soapResponseData="+soapResponseData);
//            String result = parseXMLSTRING(soapResponseData);
            return "result";
        } else {
            System.out.println("调用失败！错误码：" + statusCode);
            return "error" + statusCode;
        }
    }
    private static HttpMethod getMethod(String url,String param) throws IOException{
        GetMethod get = new GetMethod(url+"?"+param);
        get.releaseConnection();
        return get;
    }
    private static HttpMethod postMethod(String url) throws IOException{
        PostMethod post = new PostMethod(url);
        post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
        NameValuePair[] param = { new NameValuePair("sText","杭州中国")} ;
        post.setRequestBody(param);
        post.releaseConnection();
        return post;
    }
    public static void main(String[] args) throws IOException {
        TestSoap_get_post testSoap = new TestSoap_get_post();
        System.out.println("test=" + testSoap.test("中国"));
    }
    //解析xml文件，获取其中的返回值
    public static String parseXMLSTRING(String xmlString) {
        String returnJson = "";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            Element root = doc.getDocumentElement();//根节点
            Node node = root.getFirstChild();
            while (!node.getNodeName().equals("string")) {
                node = node.getFirstChild();
            }
            if (node.getFirstChild() != null) returnJson = node.getFirstChild().getNodeValue();
            System.out.println("获取的返回参数为：" + returnJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnJson;
    }

}
