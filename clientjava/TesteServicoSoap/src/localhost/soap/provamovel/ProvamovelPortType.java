/**
 * ProvamovelPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.soap.provamovel;

public interface ProvamovelPortType extends java.rmi.Remote {
    public java.lang.String login(java.lang.String email, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String cadastrar(java.lang.String email, java.lang.String senha, java.lang.String cep) throws java.rmi.RemoteException;
}
