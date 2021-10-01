/*
 * 11.09.2019 Original version
 */


package dk.via.jpe.simplegson;


public class Request
{
	private int action;
	private String text;
	
	
	public Request( int action, String text )
	{
		this.action = action;
		this.text = text;
	}
	
	
	public int getAction()
	{
		return action;
	}
	
	
	public String getText()
	{
		return text;
	}
}
