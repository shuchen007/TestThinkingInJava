/**
 * ScyxKtServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sikaiClient;

public class ScyxKtServiceLocator extends org.apache.axis.client.Service implements sikaiClient.ScyxKtService {

    public ScyxKtServiceLocator() {
    }


    public ScyxKtServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ScyxKtServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IScyxKtService
    private java.lang.String BasicHttpBinding_IScyxKtService_address = "http://10.89.2.102/ktwcf/ScyxKtService.svc";

    public java.lang.String getBasicHttpBinding_IScyxKtServiceAddress() {
        return BasicHttpBinding_IScyxKtService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IScyxKtServiceWSDDServiceName = "BasicHttpBinding_IScyxKtService";

    public java.lang.String getBasicHttpBinding_IScyxKtServiceWSDDServiceName() {
        return BasicHttpBinding_IScyxKtServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IScyxKtServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IScyxKtServiceWSDDServiceName = name;
    }

    public sikaiClient.IScyxKtService getBasicHttpBinding_IScyxKtService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IScyxKtService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IScyxKtService(endpoint);
    }

    public sikaiClient.IScyxKtService getBasicHttpBinding_IScyxKtService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sikaiClient.BasicHttpBinding_IScyxKtServiceStub _stub = new sikaiClient.BasicHttpBinding_IScyxKtServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IScyxKtServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IScyxKtServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IScyxKtService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sikaiClient.IScyxKtService.class.isAssignableFrom(serviceEndpointInterface)) {
                sikaiClient.BasicHttpBinding_IScyxKtServiceStub _stub = new sikaiClient.BasicHttpBinding_IScyxKtServiceStub(new java.net.URL(BasicHttpBinding_IScyxKtService_address), this);
                _stub.setPortName(getBasicHttpBinding_IScyxKtServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_IScyxKtService".equals(inputPortName)) {
            return getBasicHttpBinding_IScyxKtService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ScyxKtService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IScyxKtService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IScyxKtService".equals(portName)) {
            setBasicHttpBinding_IScyxKtServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
