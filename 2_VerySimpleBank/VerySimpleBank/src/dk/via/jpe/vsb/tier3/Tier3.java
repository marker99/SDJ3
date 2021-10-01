/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.tier3;

public class Tier3
{
	public static void main( String[] args )
	{
		try {
			Tier3Controller controller = new Tier3Controller();
			
			System.out.println( "Tier3 ready" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
