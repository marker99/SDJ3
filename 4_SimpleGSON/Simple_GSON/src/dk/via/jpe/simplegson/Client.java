/*
 * 11.09.2019 Original version
 */


package dk.via.jpe.simplegson;


import static dk.via.jpe.simplegson.Config.PORT;
import static dk.via.jpe.simplegson.Config.UPPER_ACTION;
import static dk.via.jpe.simplegson.Config.LOWER_ACTION;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.google.gson.Gson;


public class Client
{
	public static void main( String[] args )
	{
		new Client().run();
	}
	
	
	private String ip;
	private Gson gson = new Gson();
	
	
	private void run()
	{
		ip = JOptionPane.showInputDialog( null, "IP address" );
		
		if( ip == null || ip.length() == 0 )
			return;
			
			
		String text = JOptionPane.showInputDialog( null, "Text" );
		while( text != null && text.length() > 0 ) {
			String upper = serverCall( UPPER_ACTION, text );
			System.out.println( upper );
			
			String lower = serverCall( LOWER_ACTION, text );
			System.out.println( lower );
			
			text = JOptionPane.showInputDialog( null, "Text" );
		}
	}
	
	
	private String serverCall( int action, String text )
	{
		String result = "";
		
		try {
			Socket socket = new Socket( ip, PORT );
		
			OutputStreamWriter out = new OutputStreamWriter( socket.getOutputStream() );
			BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

			String message = gson.toJson( new Request( action, text ) );
			System.out.println( "SENDING: " + message );
			
			out.write( message + "\n" ); // write to server
			out.flush();
			
			message = in.readLine(); // read from server
			System.out.println( "RECEIVED: " + message );
			
			Response response = gson.fromJson( message, Response.class );
			result = response.getText();
		
			socket.close();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
