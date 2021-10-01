/*
 * 12.09.2018 Original version
 */


package dk.via.jpe.vsb.tier1;


import dk.via.jpe.vsb.common.ITier2;
import static dk.via.jpe.vsb.common.ITier2.T2_SERVICE_NAME;

import java.rmi.Naming;


public class Tier1
{
	// Just a simple test driver. Should be client
	
	public static void main( String[] args )
	{
		try {
			ITier2 tier2 = (ITier2) Naming.lookup( T2_SERVICE_NAME );
			
			double amount = 853.17;
			
			while( tier2.withdraw( 4711, amount ) )
				System.out.println( "Withdrawn: " + amount );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
