package com.hao.soapWebservice;


import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

/**
 *
 * 方法二： 应用document方式调用
 * 用ducument方式应用现对繁琐而灵活。现在用的比较多。因为真正摆脱了我们不想要的耦合
 *
 **/
public class TestSoap_Axis2 {
    public static void main(String[] strings) {
            String serviceEpr = "http://www.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx?wsdl";
            String nameSpace = "http://webxml.com.cn/";
            String methodName = "toTraditionalChinese";
            try {
                Options options = new Options();
                options.setAction("http://webxml.com.cn/toTraditionalChinese");
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
                OMElement nameElement = factory.createOMElement("sText", namespace);
                nameElement.addChild(factory.createOMText(nameElement, "中国"));

                method.addChild(nameElement);
                method.build();
//            options.setSoapVersionURI(org.apache.axiom.soap.SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
//                options.setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

                // 请求并得到结果
                OMElement result = sender.sendReceive(method);
                System.out.println(result.toString());
            } catch (AxisFault axisFault) {
                axisFault.printStackTrace();
            }
    }
}
