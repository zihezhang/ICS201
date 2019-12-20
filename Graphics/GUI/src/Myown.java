import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Myown extends JFrame
{
	public static void main(String[]args)
	{
			//Window
			JFrame window = new JFrame("Light Switch");//Name on the Window
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Let's the Java program close when x is pressed
			window.setSize(800, 700);//Set Size
			
			//Graphics container
			//Needed to set the layout for your graphics
			final JPanel container = new JPanel();
			container.setBackground(Color.WHITE);//Set background colour
			
			//Layout
			GridBagLayout layout = new GridBagLayout();//Layout used to set gui element alignments
			GridBagConstraints constraints = new GridBagConstraints();//Used for spacing and location
			
			//Image
			final ImageIcon tictactoe = new ImageIcon("untitled.png"); //Light on
			final ImageIcon lightOff = new ImageIcon("Light_ON_Small.png"); //Light off
			final JLabel imageLabel = new JLabel(tictactoe); //Set this label to a picture
			
			//On/Off button
			final JButton onOffButton = new JButton("Start Game");
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
						onOffButton.setText("Start Game");
						imageLabel.setIcon(tictactoe);
						container.setBackground(Color.WHITE);
					}
					else
					{
						isOn = true;
						onOffButton.setText("Main Menu");
						imageLabel.setIcon(lightOff);
						container.setBackground(Color.GRAY);
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
