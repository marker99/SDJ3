/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.tier2;

public class Tier2
{
	public static void main( String[] args )
	{
		try {
			Tier2Controller controller = new Tier2Controller();
			
			System.out.println( "Tier2 ready" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
