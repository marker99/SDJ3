/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg.server;


import dk.via.jpe.p2pmsg.common.AddressServerInterface;
import dk.via.jpe.p2pmsg.model.PeerList;
import dk.via.jpe.p2pmsg.model.Peer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class AddressServerController
	extends UnicastRemoteObject
	implements AddressServerInterface
{
	private PeerList peers = new PeerList();
	
	private AddressServerView view;
	
	
	public AddressServerController()
		throws RemoteException
	{
	}
	
	
	public void setView( AddressServerView view )
	{
		this.view = view;
	}
	
	
	public synchronized boolean registerPeer( Peer peer )
		throws RemoteException
	{
		if( peers.exists( peer ) )
			return false;
		else {
			peers.add( peer );
			
			view.println( "Inserted " + peer.getAlias() );
			return true;
		}
	}
	
	public synchronized Peer findPeer( String alias )
		throws RemoteException
	{
		view.println( "Finding " + alias );
		
		return peers.find( alias );
	}
}
