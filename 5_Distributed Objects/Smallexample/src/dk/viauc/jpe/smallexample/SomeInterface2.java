/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 10.11.2009 Original version
 */
 
package dk.viauc.jpe.smallexample;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SomeInterface2
	extends Remote
{
	public void setValue( int value )
		throws RemoteException;
	
	public int getValue()
		throws RemoteException;
}