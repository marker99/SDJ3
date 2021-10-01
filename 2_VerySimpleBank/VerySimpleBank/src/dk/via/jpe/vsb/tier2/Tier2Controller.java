/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.tier2;


import dk.via.jpe.vsb.common.ITier2;
import dk.via.jpe.vsb.common.ITier3;
import dk.via.jpe.vsb.model.Account;

import static dk.via.jpe.vsb.common.ITier3.T3_SERVICE_NAME;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Tier2Controller
	extends UnicastRemoteObject
	implements ITier2
{
	private ITier3 tier3;
	
	
	public Tier2Controller()
		throws RemoteException
	{
		try {
			Naming.rebind( T2_SERVICE_NAME, this );
			
			tier3 = (ITier3) Naming.lookup( T3_SERVICE_NAME );
		} catch( Exception ex ) {
			ex.printStackTrace();
			System.exit( 1 );
		}
	}
	
	
	public boolean withdraw( int accountNumber, double amount )
		throws RemoteException
	{
		Account account = tier3.getAccount( accountNumber );
		
		if( account == null )
			return false;
		else if( amount <= 0.0 || amount > account.getBalance() )
			return false;
		else {
			account.updateBalance( -amount );
			tier3.updateAccount( account );
			
			return true;
		}
	}
}
