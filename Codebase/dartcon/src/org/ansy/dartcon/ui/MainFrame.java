/**
 * (C) 2013 - 2013, Ansy India Pvt. Ltd., All rights reserved.
 */
package org.ansy.dartcon.ui;

import javax.swing.JFrame;

/**
 * @Author : anand <br/>
 * 
 *         Description about MainFrame : <br/>
 */
public final class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private MainFrame()
	{
		initUI();
	}

	public static void startApplication()
	{
		new MainFrame();
	}

	private void initUI()
	{
		setVisible(true);

	}

}
