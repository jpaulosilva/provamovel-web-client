/**
 * ProvamovelLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.soap.provamovel;

public class ProvamovelLocator extends org.apache.axis.client.Service implements localhost.soap.provamovel.Provamovel {

    public ProvamovelLocator() {
    }


    public ProvamovelLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProvamovelLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for provamovelPort
    private java.lang.String provamovelPort_address = "http://localhost/projetows/server/serversoap/server.php";

    public java.lang.String getprovamovelPortAddress() {
        return provamovelPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String provamovelPortWSDDServiceName = "provamovelPort";

    public java.lang.String getprovamovelPortWSDDServiceName() {
        return provamovelPortWSDDServiceName;
    }

    public void setprovamovelPortWSDDServiceName(java.lang.String name) {
        provamovelPortWSDDServiceName = name;
    }

    public localhost.soap.provamovel.ProvamovelPortType getprovamovelPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(provamovelPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getprovamovelPort(endpoint);
    }

    public localhost.soap.provamovel.ProvamovelPortType getprovamovelPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.soap.provamovel.ProvamovelBindingStub _stub = new localhost.soap.provamovel.ProvamovelBindingStub(portAddress, this);
            _stub.setPortName(getprovamovelPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setprovamovelPortEndpointAddress(java.lang.String address) {
        provamovelPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.soap.provamovel.ProvamovelPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.soap.provamovel.ProvamovelBindingStub _stub = new localhost.soap.provamovel.ProvamovelBindingStub(new java.net.URL(provamovelPort_address), this);
                _stub.setPortName(getprovamovelPortWSDDServiceName());
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
        if ("provamovelPort".equals(inputPortName)) {
            return getprovamovelPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost/soap/provamovel", "provamovel");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost/soap/provamovel", "provamovelPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("provamovelPort".equals(portName)) {
            setprovamovelPortEndpointAddress(address);
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
