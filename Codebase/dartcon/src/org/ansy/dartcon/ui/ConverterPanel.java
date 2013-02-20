/**
 * (C) 2013 - 2013, Ansy India Pvt. Ltd., All rights reserved.
 */
package org.ansy.dartcon.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ansy.dartcon.bl.Converter;

/**
 * @Author : anand <br/>
 * 
 *         Description about ConverterPanel : <br/>
 */
public class ConverterPanel extends JPanel
{

	private static final long serialVersionUID = 1L;

	public ConverterPanel()
	{
		initUI();
	}

	private void initUI()
	{
		JLabel l = new JLabel("Convert JavaScript to Dart");
		l.setBounds(130, 10, 200, 27);

		JLabel l1 = new JLabel("Source file: ");
		l1.setBounds(100, 50, 150, 27);
		final JTextField source = new JTextField();
		source.setBounds(100, 80, 350, 27);

		JLabel l2 = new JLabel("Destination Directory: ");
		l2.setBounds(100, 120, 200, 27);
		final JTextField dest = new JTextField();
		dest.setBounds(100, 150, 350, 27);

		int x = 100;
		int y = 300;
		int width = 90;
		int hieght = 27;

		setLayout(null);

		JButton convert = new JButton("Convert");
		convert.setBounds(x, y, width, hieght);
		convert.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Converter().startConversion(source.getText(), dest.getText());
			}
		});

		JButton reset = new JButton("Reset");
		reset.setBounds(x = x + 100, y, width, hieght);

		reset.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				source.setText("");
				dest.setText("");
			}
		});

		JButton close = new JButton("Close");
		close.setBounds(x + 100, y, width, hieght);

		close.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent event)
			{

				System.exit(0);

			}
		});

		add(l);
		add(l1);
		add(l2);
		add(source);
		add(dest);
		add(convert);
		add(reset);
		add(close);

	}

}
