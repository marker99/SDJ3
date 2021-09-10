/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg.common;


import java.rmi.Remote;
import java.rmi.RemoteException;

import dk.via.jpe.p2pmsg.model.Message;


public interface PeerInterface
	extends Remote
{
	public void deliverMessage( Message message ) throws RemoteException;
}
