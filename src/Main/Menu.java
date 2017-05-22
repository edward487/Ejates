package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Game.Board;
import Game.Frame;
import Game.Gun;

public class Menu extends JFrame implements ActionListener {
	 public static void main(String [] args){
			new Menu();
		}
	private Image image;
	JButton gameOver, retryButton, menu;



	public Menu(){
		
		image = new ImageIcon("Pictures/Background1.jpg").getImage();
		
		JPanel container = new MyBackground();
		container.setLayout(null);
		
		gameOver = new JButton("GAME OVER!!!");
		gameOver.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		gameOver.setBackground(null);
		gameOver.setBorder(null);
		gameOver.setEnabled(false);
		gameOver.setBounds(280, 180, 250, 50);
		
		retryButton = new JButton("Retry");
		retryButton.setFont(new Font("Courier New", Font.PLAIN, 14));
	    retryButton.setBackground(new Color(148250));
	    retryButton.setForeground(Color.GREEN);
	    retryButton.setUI(new StyledButtonUI());
        retryButton.addActionListener(this);
        retryButton.setBounds(350, 250, 70, 30);
        
        menu = new JButton("Back To Main Menu");
        menu.setFont(new Font("Courier New", Font.PLAIN, 14));
        menu.setBackground(new Color(148250));
        menu.setForeground(Color.GREEN);
        menu.setUI(new StyledButtonUI());
        menu.addActionListener(this);
        menu.setBounds(300, 300, 180, 30);
        
        
        container.add(gameOver);
        container.add(retryButton);
        container.add(menu);
        
        pack();
        add(container);
		setSize(800, 630); //size of background image horizontal, vertical
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == retryButton){
			new Board().setVisible(true);
			this.dispose();
		}

		if(e.getSource() == menu){
			new Buttons().setVisible(true);
			this.dispose();
		}
	}
	

}