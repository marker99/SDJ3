/*
 * 10.02.2015 Original version
 */


package dk.via.jpe.p2pmsg.peer;


public interface PeerView
{
	public void println( String text );
	
	public String inputAlias();
	
	public void displayAlias( String alias );
	
	public void error( String text );
}
