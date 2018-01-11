package com.hao.soapWebservice;

import sikaiClient.IScyxKtService;
import sikaiClient.ScyxKtService;
import sikaiClient.ScyxKtServiceLocator;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class TestSoap_Local {
    public static void main(String[] args0) throws RemoteException, ServiceException {
//        TraditionalSimplifiedWebService x = new TraditionalSimplifiedWebServiceLocator();
//        TraditionalSimplifiedWebServiceSoap_PortType port = x.getTraditionalSimplifiedWebServiceSoap();
//        String result =port.toTraditionalChinese("中国");
//        System.out.println(result);

        ScyxKtService y = new ScyxKtServiceLocator();
        IScyxKtService port1 = y.getBasicHttpBinding_IScyxKtService();
        String result1 = port1.CNJSNdbs("2016-02-10");
        System.out.println(result1);
    }
}
