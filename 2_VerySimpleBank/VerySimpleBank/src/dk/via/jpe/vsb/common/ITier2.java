/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.common;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ITier2
	extends Remote
{
	public boolean withdraw( int accountNumber, double amount ) throws RemoteException;
	
	
	public static final String T2_SERVICE_NAME = "rmi://localhost/T2";
}
