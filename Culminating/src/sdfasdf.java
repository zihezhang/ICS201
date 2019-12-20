import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class sdfasdf implements ActionListener
{
	private String letter = "";
	private int count = 0;
	private int oscore = 0; //new
	private int xscore = 0; //new
	private static JFrame gamePanel = new JFrame("Tic Tac Toe");
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	private JButton button3 = new JButton("");
	private JButton button4 = new JButton("");
	private JButton button5 = new JButton("");
	private JButton button6 = new JButton("");
	private JButton button7 = new JButton("");
	private JButton button8 = new JButton("");
	private JButton button9 = new JButton("");
	private JButton playagain = new JButton("Play Again");
	private JButton music = new JButton("Play Music");
	private JLabel score = new JLabel("<html>Player X's Score : "+xscore +"<br>Player O's Score : <html>" +oscore, SwingConstants.CENTER);
	private boolean win = false;

	private Sound playSound;
	static AudioInputStream audioInputStream;
	static Clip clip;
	public void playSound() 
	{
		try 
		{
			if(audioInputStream==null)
				audioInputStream = AudioSystem.getAudioInputStream(new File("Creepy_Music_Box.wav").getAbsoluteFile());
			if(clip == null)
			{
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
			}
			clip.start();
		} catch(Exception e) 
		{
			System.out.println("Error with playing sound.");
			e.printStackTrace();
		}
	}
	public void stopSound() 
	{
		try 
		{
			clip.stop();
		} catch(Exception e) 
		{
			System.out.println("Error with playing sound.");
			e.printStackTrace();
		}
	}
	
	public sdfasdf()
	{
	//create game
	gamePanel.setSize(500, 600);
	gamePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gamePanel.setLayout(new GridLayout(4, 3));
	gamePanel.setLocation(200, 100);

	//Add Buttons
	gamePanel.add(button1);
	gamePanel.add(button2);
	gamePanel.add(button3);
	gamePanel.add(button4);
	gamePanel.add(button5);
	gamePanel.add(button6);
	gamePanel.add(button7);
	gamePanel.add(button8);
	gamePanel.add(button9);
	gamePanel.add(playagain);
	gamePanel.add(music);
	gamePanel.add(score);
	
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	button5.addActionListener(this);
	button6.addActionListener(this);
	button7.addActionListener(this);
	button8.addActionListener(this);
	button9.addActionListener(this);
	playagain.addActionListener(this);
	
	music.addActionListener(new ActionListener()
	{
		boolean isOn = true;
		@Override
		//Default procedure used when the button is pressed
		public void actionPerformed(ActionEvent e)
		{

			//Logic to change the image of the label
			if(isOn)
			{
				playSound();
				isOn = false;
			}
			else
			{
				stopSound();
				isOn = true;
			}
		}

	});

	gamePanel.setVisible(true);
	}

	public void actionPerformed(ActionEvent z)
	{
		count++;

		//Who's Turn It is
		if (count%2 == 1)
		{
			letter = "X";
		}
		else if (count%2 == 0)
		{
			letter = "O";
		}


		//Displaying an X or O on the buttons
		if (z.getSource() == button1)
		{
			button1.setText(letter);
			button1.setEnabled(false);
		}
		else if (z.getSource() == button2)
		{
			button2.setText(letter);
			button2.setEnabled(false);
		}
		else if (z.getSource() == button3)
		{
			button3.setText(letter);
			button3.setEnabled(false);
		}
		else if (z.getSource() == button4)
		{
			button4.setText(letter);
			button4.setEnabled(false);
		}
		else if (z.getSource() == button5)
		{
			button5.setText(letter);
			button5.setEnabled(false);
		}
		else if (z.getSource() == button6)
		{
			button6.setText(letter);
			button6.setEnabled(false);
		}
		else if (z.getSource() == button7)
		{
			button7.setText(letter);
			button7.setEnabled(false);
		}
		else if (z.getSource() == button8)
		{
			button8.setText(letter);
			button8.setEnabled(false);
		}
		else if (z.getSource() == button9)
		{
			button9.setText(letter);
			button9.setEnabled(false);
		}
		else if (z.getSource() == playagain)
		{
			int answer = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(answer == JOptionPane.NO_OPTION)
			{
				System.exit(0);
			}
			else
			{
				new TicTacToeGUI();
			}
		}
		else if (z.getSource() == score)
		{

			JOptionPane.showMessageDialog(null, "Player X's Score" + " ");
		}
		else if (	win = true;
		}

		//Win diagonally
		else if (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "")
		{
			win = true;
		}
		else if (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
		{
			win = true;
		}
		else
		{
			win = false;
		}

		//Show who wins or if a tie
		if (win == true)
		{
			JOptionPane.showMessageDialog(null, letter +" Wins!");

		}
		else if (count == 9 && win == false)
		{
			JOptionPane.showMessageDialog(null, "It's a tie!");
		}
			
	}
	//track scores
	void Scores()
	{
		if(letter.equals("X"))
		{
			xscore++;
			score.setText("Player X's Score:"+ xscore);
		}
		if(letter.equals("0"))
		{
			oscore++;
		}
	}


	public static void main(String[]args)
	{
		//Window
		final JFrame window = new JFrame("Light Switch");//Name on the Window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Let's the Java program close when x is pressed
		window.setSize(500, 600);//Set Size		
		
		//Graphics container
		//Needed to set the layout for your graphics
		final JPanel startPanel = new JPanel();
		startPanel.setBackground(Color.WHITE);//Set background colour
		
		//Layout
		GridBagLayout layout = new GridBagLayout();//Layout used to set ui element alignments
		GridBagConstraints constraints = new GridBagConstraints();//Used for spacing and location

		//Image
		final ImageIcon title = new ImageIcon("Untitled.png"); //Light on
		final ImageIcon lightOff = new ImageIcon("Light_Off_Small.png"); //Light off
		final JLabel imageLabel = new JLabel(title); //Set this label to a picture
		final JLabel imageLabel2 = new JLabel(lightOff);
		startPanel.add(imageLabel);
		
		//On/Off button
		final JButton initial = new JButton("Start Game");
		startPanel.add(initial);
		//This adds function to your button
		//You can make an actionlistener yourself outside of the program and add that if you like
		initial.addActionListener(@�F;FE trace/2   �8cC1 enableObjectName/1���� getNextSibling/0   t������>l��,�8'8�9�= unmarshalValue/2���� wrongInterfaceDef/2���? getCycleTime/0���	 targetCreatedPeer/2���� exceptionInArguments/0���E setDefaultAction/1   �km~����6�6� lambda$groupingBy$139/2��� isOwnedBy/1   )�)� getClientInputMethodRequests/0���3 flush/1   $I$J?#?'@�D� systemNodeForPackage/1��՛ clearTagCache/0���� getInputMethodRequests/0    � 46�>�?�?� getDeltaHistogram/0���7 year/0��� internalNextLong/2   ('(h)� initStAXExConnector/0��� getEtchType/0���U 
isBefore/3   1N4P6�6�6� setOutputAreaXYXY/4   BBB updateResult/1   STV isPrimitive/0   fp!T!�-- "makeRequestPartitioningComponent/1���� getValueHistogram/0���7 expandRelatedComponents/3��� getLoggerName/0��ո getColorForGap/3���� ensureInitialization/0���� quietlyJoin/0��֜ insert/9���9 getQueuedReaderThreads/0��� badGiopRequestType/2���? isBranchOp/1��� getAuthType/0   D�D� isInterface/0   
�!�-F� new ActionListener()
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
					window.remove(gamePanel);
					window.add(startPanel);
					window.validate();
					
				}
				else
				{
					isOn = true;
					window.remove(startPanel);
					window.add(gamePanel);
					window.validate();
				}
			}
		});

		//Add Components
		startPanel.setLayout(layout); //set layout to grid layout
		startPanel.add(imageLabel);
		constraints.gridy = 1; //put the button image beneath the light image, 0 = light, 1 = button
		//insets(top, left, bottom, right);
		constraints.insets = new Insets(25,0,0,0);//Set padding above the button by 25 pixels
		startPanel.add(initial,constraints);
		window.add(startPanel);
		//Do this at the end
		window.setVisible(true);
	}

}