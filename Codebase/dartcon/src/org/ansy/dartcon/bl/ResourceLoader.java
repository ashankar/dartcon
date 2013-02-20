/**
 * (C) 2013 - 2013, Ansy India Pvt. Ltd., All rights reserved.
 */
package org.ansy.dartcon.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author : anand <br/>
 * 
 *         Description about ResourceLoader : <br/>
 */
public class ResourceLoader
{

	public void loadSourceFile(String source)
	{
		File file = null;
		FileInputStream fin = null;

		try
		{
			
			file=new File(source);
			fin=new FileInputStream(file);
			
			

		} catch(IOException ioe)
		{
			System.out.println(ioe);

		} finally
		{

			try
			{
				if(fin != null)
				{
					fin.close();
				}
				
				
			} catch(IOException ioe)
			{
				System.out.println(ioe);
			}

		}

	}

	public void loadPropertyFile()
	{

	}

}
