package com.hao.soapWebservice;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class TestSoap_HttpClient4_5 {

public static String PlatformUrl="http://www.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx?wsdl";
    public String requestSummary(String text) {
        //使用soapUi获取x2数据
        String x2 = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://webxml.com.cn/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <web:toTraditionalChinese>\n" +
                "         <!--Optional:-->\n" +
                "         <web:sText>"+text+"</web:sText>\n" +
                "      </web:toTraditionalChinese>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        String jsonStr="[]";
        String responseStr = "";
        try {
            System.out.println("x2="+x2);
            //两种方式创建httpClient都可以。
//           HttpClient httpClient= HttpClients.createDefault();
            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httppost = new HttpPost(PlatformUrl);
            httppost.setHeader("SOAPAction","http://webxml.com.cn/toTraditionalChinese");
            HttpEntity he = new StringEntity(x2, "UTF-8");
            //以下两种方式都可以
//            httppost.setHeader("Content-Type","text/xml;charset=UTF-8");
            httppost.setHeader("Content-Type","application/soap+xml; charset=utf-8");

            httppost.setEntity(he);
            System.out.println("httppost="+httppost);
            HttpResponse response = httpClient.execute(httppost);
            System.out.println("response="+response);

            // 6.获取服务端返回的状态码
            int statuscode = response.getStatusLine().getStatusCode();
            System.out.println("response.getStatusLine()="+response.getStatusLine().getProtocolVersion());
            System.out.println("response.getLocale()="+response.getLocale());
            System.out.println("response.getEntity()="+response.getEntity().getContent());
            System.out.println("statuscode="+statuscode);

            responseStr = EntityUtils.toString(response.getEntity());
            System.out.println("responseStr="+responseStr);
//            responseStr=responseStr.replaceAll("&quot;", "\"");
            jsonStr= getReponseJson(responseStr);
//            jsonStr= getReponseJson(responseStr).replaceAll("\"null\"", "\"\"").replaceAll("null", "\"\"");

        } catch (Exception e) {}

        return jsonStr;
    }


    public static void main(String[] strings){
        TestSoap_HttpClient4_5 updateService = new TestSoap_HttpClient4_5();
        System.out.println("do="+updateService.requestSummary("中国"));
    }

    /**
     * 获取JSON字符串
     * @param docXml
     * @return
     */
    static	String getReponseJson(String docXml)
    {

        ByteArrayInputStream bInputStream;
        Document doc ;
        String jsonStr="[]";
        try {
            bInputStream = new ByteArrayInputStream(docXml.getBytes("UTF-8"));
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc=builder.parse(bInputStream);
//            NodeList nList= doc.getElementsByTagName("return");
            NodeList nList= doc.getElementsByTagName("toTraditionalChineseResult");
            System.out.println("nList="+nList);
            if (nList.getLength()>0) {
                Node dNode=nList.item(nList.getLength()-1);
                System.out.println("dNode="+dNode);
                jsonStr = dNode.getTextContent();
            }
        } catch (Exception e) {
            // 	LogUtil.WLog("c:\\log\\permissLog.txt", e.getMessage()+"@##########");
            e.printStackTrace();
        }
        return jsonStr;
    }
}
