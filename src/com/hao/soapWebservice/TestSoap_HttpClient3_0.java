package com.hao.soapWebservice;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;


public class TestSoap_HttpClient3_0 {

    public String test(String text) throws IOException {
        // TODO Auto-generated method stub
        String soapRequestData = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webxml.com.cn/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <web:toTraditionalChinese>\n" +
                "         <!--Optional:-->\n" +
                "         <web:sText>"+text+"</web:sText>\n" +
                "      </web:toTraditionalChinese>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        System.out.println(soapRequestData);

        PostMethod postMethod = new PostMethod("http://www.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx?wsdl");

        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        postMethod.addRequestHeader("SOAPAction","http://webxml.com.cn/toTraditionalChinese");//某些网络必须要使用header
        // 然后把Soap请求数据添加到PostMethod中
        byte[] b = soapRequestData.getBytes("utf-8");
        InputStream is = new ByteArrayInputStream(b, 0, b.length);
//        RequestEntity re = new InputStreamRequestEntity(is, b.length, "application/soap+xml; charset=utf-8");//soap12配置
//        RequestEntity re = new InputStreamRequestEntity(is, b.length, "application/xop+xml; charset=UTF-8; type=\"text/xml\"");
        RequestEntity re = new InputStreamRequestEntity(is, b.length,"text/xml;charset=UTF-8");//soap11配置
        postMethod.setRequestEntity(re);

        // 最后生成一个HttpClient对象，并发出postMethod请求
        HttpClient httpClient = new HttpClient();
        System.out.println("postMethod="+postMethod);
        int statusCode = httpClient.executeMethod(postMethod);
        if (statusCode == 200) {
            int count = 0;
            System.out.println("调用成功！");
            String soapResponseData = postMethod.getResponseBodyAsString();
            System.out.println("soapResponseData="+soapResponseData);
            int beginIndex = soapResponseData.indexOf("<toTraditionalChineseResult>");
            int endIndex = soapResponseData.indexOf("</toTraditionalChineseResult>");
//            count = Integer.parseInt(soapResponseData.substring(beginIndex, endIndex).replace("<toTraditionalChineseResult>中國", ""));
            System.out.println("send success numbers:" + count + "----->" + beginIndex + endIndex);
            String result = parseXMLSTRING(soapResponseData);
            return result;
        } else {
            System.out.println("调用失败！错误码：" + statusCode);
            return "error" + statusCode;
        }
    }

    public static void main(String[] args) throws IOException {
        TestSoap_HttpClient3_0 testSoap = new TestSoap_HttpClient3_0();
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
            while (!node.getNodeName().equals("toTraditionalChineseResult")) {
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
