package localhost.soap.provamovel;

public class ProvamovelPortTypeProxy implements localhost.soap.provamovel.ProvamovelPortType {
  private String _endpoint = null;
  private localhost.soap.provamovel.ProvamovelPortType provamovelPortType = null;
  
  public ProvamovelPortTypeProxy() {
    _initProvamovelPortTypeProxy();
  }
  
  public ProvamovelPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initProvamovelPortTypeProxy();
  }
  
  private void _initProvamovelPortTypeProxy() {
    try {
      provamovelPortType = (new localhost.soap.provamovel.ProvamovelLocator()).getprovamovelPort();
      if (provamovelPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)provamovelPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)provamovelPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (provamovelPortType != null)
      ((javax.xml.rpc.Stub)provamovelPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.soap.provamovel.ProvamovelPortType getProvamovelPortType() {
    if (provamovelPortType == null)
      _initProvamovelPortTypeProxy();
    return provamovelPortType;
  }
  
  public java.lang.String login(java.lang.String email, java.lang.String senha) throws java.rmi.RemoteException{
    if (provamovelPortType == null)
      _initProvamovelPortTypeProxy();
    return provamovelPortType.login(email, senha);
  }
  
  public java.lang.String cadastrar(java.lang.String email, java.lang.String senha, java.lang.String cep) throws java.rmi.RemoteException{
    if (provamovelPortType == null)
      _initProvamovelPortTypeProxy();
    return provamovelPortType.cadastrar(email, senha, cep);
  }
  
  
}