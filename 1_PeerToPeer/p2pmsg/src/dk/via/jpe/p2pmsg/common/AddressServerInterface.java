/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg.common;


import java.rmi.Remote;
import java.rmi.RemoteException;

import dk.via.jpe.p2pmsg.model.Peer;


public interface AddressServerInterface
	extends Remote
{
	public boolean registerPeer( Peer peer ) throws RemoteException;
	
	public Peer findPeer( String alias ) throws RemoteException;
	
	
	public static final String SERVICE_NAME = "p2padr";
}
