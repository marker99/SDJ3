/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg.server;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class AddressServerFrame
	extends JFrame
	implements AddressServerView
{
	private AddressServerController controller;
	
	
	JTextArea area = new JTextArea( 20, 50 );
	
	
	public AddressServerFrame( AddressServerController controller )
	{
		super( "Address Server" );
		
		this.controller = controller;
		
		area.setEditable( false );
		add( new JScrollPane( area ) );

		pack();
		setLocationRelativeTo( null );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	
	public void println( String text )
	{
		area.append( text + "\n" );
		area.setCaretPosition( area.getText().length() );
	}
}