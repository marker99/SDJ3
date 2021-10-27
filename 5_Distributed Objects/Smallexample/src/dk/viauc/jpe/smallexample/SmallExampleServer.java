/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 18.04.2010 craeteRegistry
 * 10.11.2009 Original version
 */
 
package dk.viauc.jpe.smallexample;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.net.InetAddress;


public class SmallExampleServer
{
	public static void main( String[] args )
	{
		try {
			LocateRegistry.createRegistry( 1099 );
			
			SmallExampleServerController controller = new SmallExampleServerController();
		
			Naming.rebind( "smallexample", controller );
			
			System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
			System.out.println();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
