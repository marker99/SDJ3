/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 10.11.2009 Original version
 */
 
package dk.viauc.jpe.smallexample;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class SmallExampleServerController
	extends UnicastRemoteObject
	implements SmallExample
{
	public SmallExampleServerController()
		throws RemoteException
	{
		super();
	}
	
	
	public void call1( SomeObject1 obj1 )
		throws RemoteException
	{
		System.out.println( "value1: " + obj1.getValue() );
		obj1.setValue( 4711 );
		System.out.println( "value1: " + obj1.getValue() );
		System.out.println();
	}
	
	
	public void call2( SomeInterface2 obj2 )
		throws RemoteException
	{
		System.out.println( "value2: " + obj2.getValue() );
		obj2.setValue( 4711 );
		System.out.println( "value2: " + obj2.getValue() );
		System.out.println();
	}
}
