/**
 * (C) 2013 - 2013, Ansy India Pvt. Ltd., All rights reserved.
 */
package org.ansy.dartcon;

import org.ansy.dartcon.bl.ResourceLoader;

/**
 * @Author : anand <br/>
 * 
 *         Description about EntryPoint : <br/>
 */
public class EntryPoint
{

	public static void main(String[] args)
	{

		// MainFrame.startApplication();
		new ResourceLoader().loadPropertyFile();

	}

}
