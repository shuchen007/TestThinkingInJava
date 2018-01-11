package com.hao.soapWebservice;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.StringUtils;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

/**
 * 测试自己建立的服务器端代码.服务本地化。axis方法测试。
 */
public class TestWebSvrClient {


    public static void main(String[] args) {
//        String url = "http://localhost:8080/test/services/HelloWorld";
        String url = "http://www.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx";
//        String url = "http://10.89.2.102/ktwcf/ScyxKtService.svc?wsdl";
//        String url = "http://localhost:8080/test/services/BasicHttpBinding_IScyxKtService?wsdl";
//        String method = "testParams3";
        String method = "toTraditionalChinese";
//        String method = "CNJSNdbs";
        //设置方法中参数的值
//        Object[] parms = new Object[] {"2016-01-23"};
        Object[] parms = new Object[]{"中国"};
        TestWebSvrClient webClient = new TestWebSvrClient();
        String svrResult = webClient.CallMethod(url, method, parms);
        System.out.println(svrResult);
    }

    public String CallMethod(String url, String method, Object[] args) {
        String result = null;
        Call call = null;
        try {
//            String targetNamespace = "http://example";
            //实例websevice调用实例
            Service webService = new Service();
            call = (Call) webService.createCall();
            call.setTargetEndpointAddress(new java.net.URL(url));
            //你需要远程调用的方法
            call.setOperationName(new QName("http://webxml.com.cn/",method));
            call.setSOAPActionURI("http://webxml.com.cn/toTraditionalChinese");
            //方法参数，如果没有参数请无视
            call.addParameter(new QName("http://webxml.com.cn/","中国"), XMLType.XSD_STRING, ParameterMode.IN);
            call.setOperationName(method);

            //执行webservice方法
            result = (String) call.invoke(args);
//            result = (String) call.invoke(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
