/**
 * (C) 2013 - 2013, Ansy India Pvt. Ltd., All rights reserved.
 */
package org.ansy.dartcon.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @Author : anand <br/>
 * 
 *         Description about ResourceLoader : <br/>
 */
public class ResourceLoader
{

	public void loadSourceFile(String source, String dest)
	{
		File file = null;
		FileInputStream fin = null;

		try
		{

			file = new File(source);
			fin = new FileInputStream(file);
			int size = fin.available();
			StringBuffer sb = new StringBuffer();

			for(int i = 0; i < size; i++)
			{
				sb.append((char) fin.read());
			}

			String data = sb.toString();
			String parsedData = parseString(data);
			String fileInfo[] = getFileType(file.getName());

			writeToFile(parsedData, dest, fileInfo);

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

	private String parseString(String data)
	{

		Set<Entry<Object, Object>> entrySet = null;//loadPropertyFile();

		String parsedData = data;

		for(Entry<Object, Object> entry : entrySet)
		{

			parsedData = parsedData.replaceAll(entry.getKey().toString(), entry.getValue().toString());

		}

		return parsedData;

	}

	public void loadPropertyFile()
	{
		// Set<Entry<Object, Object>>
		Properties prop = new Properties();
		File file = new File("resources", "js2dart.properties");
		Set<Entry<Object, Object>> entrySet = null;
		FileInputStream fin = null;

		try
		{

			fin = new FileInputStream(file);
			prop.load(fin);
			entrySet = prop.entrySet();

			for(Entry<Object, Object> en : entrySet)
			{
				System.out.println(en.getKey() + " = " + en.getValue());
			}

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

		// return entrySet;

	}

	private void writeToFile(String parsedData, String destPath, String fileInfo[])
	{

		String fileName = fileInfo[0];
		String fileType = fileInfo[1];
		String finalFileName = "";

		if(fileType.equalsIgnoreCase("js"))
		{
			finalFileName = fileName + "." + "dart";

		} else if(fileType.equalsIgnoreCase("dart"))
		{
			finalFileName = fileName + "." + "js";

		}

		File file = new File(destPath, finalFileName);
		FileWriter fw = null;

		try
		{
			fw = new FileWriter(file);
			fw.write(parsedData);
			System.out.println("File create! Location : " + destPath + " File Name : " + finalFileName);

		} catch(IOException ioe)
		{
			System.out.println(ioe);

		} catch(Exception e)
		{
			System.out.println(e);

		} finally
		{

			try
			{
				if(fw != null)
				{
					fw.close();
				}

			} catch(IOException ioe)
			{
				System.out.println(ioe);
			}
		}

	}

	private String[] getFileType(String fileName)
	{

		String fileInfo[] = new String[2];
		int index = 0;
		StringTokenizer st = new StringTokenizer(fileName, ".");

		while(st.hasMoreElements())
		{

			fileInfo[index] = st.nextToken();
			index++;
		}

		return fileInfo;
	}

	// public void setProperty() {
	//
	// Properties prop = new Properties();
	// File file = new File("resources", "dartcon.properties");
	//
	// FileInputStream fin = null;
	// FileOutputStream o = null;
	// try {
	//
	// // fin = new FileInputStream(file);
	//
	// prop.setProperty("mykey2", "my Value2");
	//
	// o = new FileOutputStream(file);
	// prop.store(o, "This is 2 stored");
	// System.out.println(prop.stringPropertyNames());
	//
	// } catch (IOException ioe) {
	// System.out.println(ioe);
	//
	// } finally {
	//
	// try {
	// o.close();
	// if (fin != null) {
	// fin.close();
	// }
	//
	// } catch (IOException ioe) {
	// System.out.println(ioe);
	// }
	//
	// }
	//
	// }

}
