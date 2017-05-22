package Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import Game.Board;
import Game.Frame;
import Game.Music;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.applet.Applet;
import java.applet.AudioClip;
import java.applet.AudioClip.*;
import java.net.URL;
 
public class Buttons extends JFrame implements ActionListener{

  public static void main(String[] args) {

        new Buttons();
    }
  
  private Image image;
  JButton startButton, howButton, creditButton, exitButton;
  
  	
  public Buttons() {

        image = new ImageIcon("Pictures/mainbg.png").getImage();
        Music.play("Sound/Sound.wav", 0, 1);
        JPanel container = new MyBackground();
        container.setLayout(null);
        startButton = new JButton("Start");
        startButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        startButton.setBackground(new Color(148250));
        startButton.setForeground(Color.GREEN);
        startButton.setUI(new StyledButtonUI());
        startButton.addActionListener(this);
        startButton.setBounds(350, 250, 100, 40);
        
        howButton = new JButton("How to Play");
        howButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        howButton.setBackground(new Color(148250));
        howButton.setForeground(Color.GREEN);
        howButton.setUI(new StyledButtonUI());
        howButton.addActionListener(this);
        howButton.setBounds(310, 300, 170, 40);
        
        creditButton = new JButton("Credits");
        creditButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        creditButton.setBackground(new Color(148250));
        creditButton.setForeground(Color.GREEN);
        creditButton.setUI(new StyledButtonUI());
        creditButton.addActionListener(this);
        creditButton.setBounds(330, 350, 130, 40);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Courier New", Font.PLAIN, 20));
        exitButton.setBackground(new Color(148250));
        exitButton.setForeground(Color.GREEN);
        exitButton.setUI(new StyledButtonUI());
        exitButton.addActionListener(this);
        exitButton.setBounds(350, 400, 100, 40);
        
        container.add(startButton);
        container.add(howButton);
        container.add(creditButton);
        container.add(exitButton);   
        add(container);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,630);
        setResizable(false);
        setLocationRelativeTo(null);//to appear in the center
        setVisible(true);

    }
	/* URL url = Frame.class.getResource("Sound/Sound.wav");
	 AudioClip clip=Applet.newAudioClip(url);

	public void Music(){
		startButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		clip.startButton();
		}
		});
	}*/

    public class MyBackground extends JPanel {
        public MyBackground() {
            setBackground(new Color(0, true));
        }
        @Override
        public void paintComponent(Graphics g) {
            //Paint background first
            g.drawImage (image, 0, 0, getWidth (), getHeight (), this);
            //Paint the rest of the component. Children and self etc.
            super.paintComponent(g);
        }

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stsu
		if(e.getSource()==startButton){
			new Frame().setVisible(true);
			this.dispose();
				
		}
		if(e.getSource()==howButton){
			new HowtoPlay();
			this.dispose();
		}
		if(e.getSource()==creditButton){
			new Credit();
			this.dispose();
		}
		if(e.getSource()==exitButton){
			System.exit(0);
		}
		
	}

}
