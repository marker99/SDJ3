/*
 * 20.02.2017 import edited
 * 05.04.2011 Edited
 * 10.11.2009 Original version
 */
 
package dk.viauc.jpe.smallexample;


import java.rmi.Naming;
import javax.swing.JOptionPane;


public class SmallExampleClient
{
	public static void main( String[] args )
	{
		try {
			String ip = JOptionPane.showInputDialog( null, "IP" );
			String URL = "rmi://" + ip + "/smallexample";
			
			SmallExample server = (SmallExample) Naming.lookup( URL );
			
			SomeObject1 obj1 = new SomeObject1();
			
			obj1.setValue( 42 );
			
			System.out.println( "value1: " + obj1.getValue() );
			server.call1( obj1 );
			System.out.println( "value1: " + obj1.getValue() );
			System.out.println();
			
			SomeObject2 obj2 = new SomeObject2();
			
			obj2.setValue( 42 );
			
			System.out.println( "value2: " + obj2.getValue() );
			server.call2( obj2 );
			System.out.println( "value2: " + obj2.getValue() );
			System.out.println();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
