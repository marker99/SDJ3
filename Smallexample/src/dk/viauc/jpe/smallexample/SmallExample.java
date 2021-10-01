/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 10.11.2009 Original version
 */
 
package dk.viauc.jpe.smallexample;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SmallExample
	extends Remote
{
	public void call1( SomeObject1 obj1 )
		throws RemoteException;
		
	public void call2( SomeInterface2 obj2 )
		throws RemoteException;
}
