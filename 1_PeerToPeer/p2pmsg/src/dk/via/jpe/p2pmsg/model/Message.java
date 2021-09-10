/*
 * 13.02.2017 imports edited
 * 09.02.2015 Original version
 */


package dk.via.jpe.p2pmsg.model;


import java.io.Serializable;


public class Message
	implements Serializable
{
	private String text;
	private Peer from;
	private Peer to;
	
	
	public Message( String text, Peer from, Peer to )
	{
		this.text = text;
		this.from = from;
		this.to = to;
	}
	
	
	public String getText()
	{
		return text;
	}
	
	
	public Peer getFrom()
	{
		return from;
	}
	
	
	public Peer getTo()
	{
		return to;
	}
}
