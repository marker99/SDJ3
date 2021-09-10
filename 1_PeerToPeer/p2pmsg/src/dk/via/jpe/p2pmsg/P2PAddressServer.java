/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dk.via.jpe.p2pmsg.common.AddressServerInterface;
import dk.via.jpe.p2pmsg.server.AddressServerController;
import dk.via.jpe.p2pmsg.server.AddressServerView;
import dk.via.jpe.p2pmsg.server.AddressServerFrame;


public class P2PAddressServer
{
	public static void main( String[] args )
	{
		try {
			AddressServerController controller = new AddressServerController();
			AddressServerView view = new AddressServerFrame( controller );
		
			controller.setView( view );
			
			LocateRegistry.createRegistry( 1099 );
			
			Naming.rebind( AddressServerInterface.SERVICE_NAME, controller );
			
			view.println( "Address Server is running" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
