package com.hao.soapWebservice;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class Test_sikai_service02 {


    public static void main(String[] strings) {
//        String serviceEpr = "http://10.89.2.102/ktwcf/ScyxKtService.svc?wsdl";
//        String nameSpace = "http://tempuri.org/";
//        String methodName = "CNJSNdbs";
//        String methodName = "GetScyxUnit";
        String serviceEpr = "http://10.89.5.227/YXGLXXXT4_WAP_ReportService/services/YXGLXXXT_Service.asmx?wsdl";
        String nameSpace = "http://localhost/TreeService";
        String methodName = "MethodParameterList";
        try {
            Options options = new Options();
//            options.setAction("http://tempuri.org/IScyxKtService/CNJSNdbs");
            options.setAction("http://localhost/TreeService/MethodParameterList");
            // 指定调用WebService的URL
            EndpointReference endpointReference = new EndpointReference(serviceEpr);
            //确定目标服务地址
            options.setTo(endpointReference);

            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);
            // 创建一个OMFactory，下面的namespace、方法与参数均需由它创建
            OMFactory factory = OMAbstractFactory.getOMFactory();
            // 创建命名空间
            OMNamespace namespace = factory.createOMNamespace(nameSpace, "");
            // 创建一个method对象
            OMElement method = factory.createOMElement(methodName, namespace);
            // 参数对数
            OMElement nameElement = factory.createOMElement("methodName", namespace);
            nameElement.addChild(factory.createOMText(nameElement, "getTRQXSJHZXQK_YEAR"));
            method.addChild(nameElement);
            method.build();

            options.setSoapVersionURI(org.apache.axiom.soap.SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
//            options.setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

            // 请求并得到结果
            OMElement result = sender.sendReceive(method);
//            String resultOut = parseXMLSTRING(result.toString());
            System.out.println(result.toString());
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
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
            while (!node.getNodeName().equals("CNJSNdbsResult")) {
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
