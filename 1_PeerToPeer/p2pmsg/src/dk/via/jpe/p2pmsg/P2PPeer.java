/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg;


import dk.via.jpe.p2pmsg.peer.PeerController;
import dk.via.jpe.p2pmsg.peer.PeerView;
import dk.via.jpe.p2pmsg.peer.PeerFrame;


public class P2PPeer
{
	public static void main( String[] args )
	{
		try {
			PeerController controller = new PeerController();
			PeerView view = new PeerFrame( controller );
	
			controller.setView( view );
			controller.begin();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
