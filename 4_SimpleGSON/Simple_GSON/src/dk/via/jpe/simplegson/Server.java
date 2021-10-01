/*
 * 20.09.2020 Switched to Runnable
 * 11.09.2019 Original version
 */


package dk.via.jpe.simplegson;

import static dk.via.jpe.simplegson.Config.PORT;
import static dk.via.jpe.simplegson.Config.UPPER_ACTION;
import static dk.via.jpe.simplegson.Config.LOWER_ACTION;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;


public class Server
{
	public static void main( String[] args )
	{
		new Server().run();
	}
	
	
	private Gson gson = new Gson();
	
	
	private void run()
	{
		try {
			ServerSocket welcomeSocket = new ServerSocket( PORT );
			
			System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
			
			while( true ) {
				Socket clientSocket = welcomeSocket.accept();
				
				new Thread( new ServerThread( clientSocket ) ).start();
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	
	private void doWork( Socket clientSocket )
		throws Exception
	{
		BufferedReader in = new BufferedReader(
			new InputStreamReader( clientSocket.getInputStream() ) );
					 
		OutputStreamWriter out =
			new OutputStreamWriter( clientSocket.getOutputStream() );
		
		String message = in.readLine();
		System.out.println( "RECEIVED: " + message );
		
		Request request = (Request) gson.fromJson( message, Request.class );
		Response response;
		
		switch( request.getAction() ) {
			case UPPER_ACTION:
				response = new Response( request.getText().toUpperCase() );
				break;
				
			case LOWER_ACTION:
				response = new Response( request.getText().toLowerCase() );
				break;
				
			default:
				response = new Response( request.getText() );
				break;
		}
				
		message = gson.toJson( response );
		System.out.println( "SENDING: " + message );
		out.write( message + "\n" );
		out.flush();
					
		clientSocket.close();
	}
	
	
	private class ServerThread
		implements Runnable
	{
		private Socket clientSocket;
		
		
		public ServerThread( Socket clientSocket )
		{
			this.clientSocket = clientSocket;
		}
		
		
		public void run()
		{
			try {
				doWork( clientSocket );
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		}
	}
}
