/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 10.11.2009 Original version
 */
 
package dk.viauc.jpe.smallexample;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class SomeObject2
	extends UnicastRemoteObject
	implements SomeInterface2
{
	private int value;
	
	
	public SomeObject2()
		throws RemoteException
	{
		super();
	}
	
	
	public void setValue( int value )
		throws RemoteException
	{
		this.value = value;
	}
	
	
	public int getValue()
		throws RemoteException
	{
		return value;
	}
}