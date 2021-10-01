/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.common;


import dk.via.jpe.vsb.model.Account;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ITier3
	extends Remote
{
	public Account getAccount( int accountNumber ) throws RemoteException;
	
	public void updateAccount( Account account ) throws RemoteException;
	
	
	public static final String T3_SERVICE_NAME = "rmi://localhost/T3";
}
