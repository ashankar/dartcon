/**
 * (C) 2013 - 2013, Ansy India Pvt. Ltd., All rights reserved.
 */
package org.ansy.dartcon.bl;

/**
 * @Author : anand <br/>
 * 
 *         Description about Converter : <br/>
 */
public class Converter
{

	public void startConversion(String source, String dest)
	{
		
		new ResourceLoader().loadSourceFile(source, dest);
		
	}
}
