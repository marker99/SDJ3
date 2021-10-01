/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.tier3;


import dk.via.jpe.vsb.common.ITier3;
import dk.via.jpe.vsb.model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Tier3Controller
	extends UnicastRemoteObject
	implements ITier3
{
	public Tier3Controller()
		throws RemoteException
	{
		try {
			Naming.rebind( T3_SERVICE_NAME, this );
System.out.println( "account #4711 balance=" + account4711.getBalance() );
		} catch( Exception ex ) {
			ex.printStackTrace();
			System.exit( 1 );
		}
	}
	
	
	// This is just a stub. Here some real database stuff should go
	
	private Account account4711 = new Account( 4711, 5321.46 );
	
	
	public Account getAccount( int accountNumber )
		throws RemoteException
	{
		if( accountNumber == 4711 )
			return account4711;
		else
			return null;
	}
	
	
	public void updateAccount( Account account )
		throws RemoteException
	{
		if( account.getNumber() == 4711 )
			account4711 = account;		
System.out.println( "account #4711 balance=" + account4711.getBalance() );
	}
}
