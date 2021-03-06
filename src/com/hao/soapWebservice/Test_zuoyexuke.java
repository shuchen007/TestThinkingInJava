package com.hao.soapWebservice;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class Test_zuoyexuke {

        public static String PlatformUrl="http://10.89.2.156:5055/jsvc/service/LoginLdapService.soap/ldapvalidate";
//    public static String PlatformUrl="http://10.89.2.102/ktwcf/ScyxKtService.svc/GetScyxUnit";
//    public static String PlatformUrl="http://10.89.2.102/ktwcf/ScyxKtService.svc?wsdl";

    public String requestSummary() {
        String x2 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.uas.rfcd.com/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:ldapvalidate>\n" +
                "         <!--Optional:-->\n" +
                "         <ser:arg0>k2test5</ser:arg0>\n" +
                "         <!--Optional:-->\n" +
                "         <ser:arg1>k2test5</ser:arg1>\n" +
                "      </ser:ldapvalidate>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String jsonStr="[]";
        String responseStr = "";
        try {
            System.out.println("x2="+x2);
            //两种方式创建httpClient都可以。
//           HttpClient httpClient= HttpClients.createDefault();
            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httppost = new HttpPost(PlatformUrl);

            HttpEntity he = new StringEntity(x2, "UTF-8");
            //以下两种方式都可以
            httppost.setHeader("Content-Type","text/xml;charset=UTF-8");
//            httppost.setHeader("Content-Type","application/soap+xml; charset=utf-8");
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
//            jsonStr= getReponseJson(responseStr);
//            jsonStr= getReponseJson(responseStr).replaceAll("\"null\"", "\"\"").replaceAll("null", "\"\"");

        } catch (Exception e) {}

        return jsonStr;
    }


    public static void main(String[] strings){
        Test_zuoyexuke updateService = new Test_zuoyexuke();
        System.out.println("do="+updateService.requestSummary());
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
            NodeList nList= doc.getElementsByTagName("GetScyxUnitResult");
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
