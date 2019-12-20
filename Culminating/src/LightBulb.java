import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LightBulb 
{
	public static void main(String[]args)
	{
		//Window
		JFrame window = new JFrame("Light Switch");//Name on the Window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Let's the Java program close when x is pressed
		window.setSize(640, 480);//Set Size
		
		//Graphics container
		//Needed to set the layout for your graphics
		final JPanel container = new JPanel();
		container.setBackground(Color.GRAY);//Set background colour
		
		//Layout
		GridBagLayout layout = new GridBagLayout();//Layout used to set ui element alignments
		GridBagConstraints constraints = new GridBagConstraints();//Used for spacing and location
		
		//Image
		final ImageIcon light = new ImageIcon("Light_On_Small.png"); //Light on
		final ImageIcon lightOff = new ImageIcon("Light_Off_Small.png"); //Light off
		final JLabel imageLabel = new JLabel(lightOff); //Set this label to a picture
		
		//On/Off button
		final JButton onOffButton = new JButton("Click On");
		//This adds function to your button
		//You can make an actionlistener yourself outside of the program and add that if you like
		onOffButton.addActionListener(new ActionListener()
		{
			boolean isOn = false;
			@Override
			//Default procedure used when the button is pressed
			public void actionPerformed(ActionEvent e) 
			{
				//Logic to change the image of the label
				if(isOn)
				{
					isOn = false;
					onOffButton.setText("Click On");
					imageLabel.setIcon(lightOff);
					container.setBackground(Color.GRAY);
				}
				else
				{
					isOn = true;
					onOffButton.setText("Click Off");
					imageLabel.setIcon(light);
					container.setBackground(Color.WHITE);
				}
			}
		});
		//Add Components
		container.setLayout(layout); //set layout to grid layout
		container.add(imageLabel);
		constraints.gridy = 1; //put the button image beneath the light image, 0 = light, 1 = button
		//insets(top, left, bottom, right);
		constraints.insets = new Insets(25,0,0,0);//Set padding above the button by 25 pixels
		container.add(onOffButton,constraints);
		window.add(container);
		//Do this at the end
		window.setVisible(true);
	}
}
