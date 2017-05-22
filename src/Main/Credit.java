package Main;

import java.awt.BorderLayout;
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
import javax.swing.JTextArea;

public class Credit extends JFrame implements ActionListener{

	  public static void main(String[] args) {

	        new Credit();

	    }
	  
	  private Image image;
	  JButton backmenu;
	  
	  public Credit() {

	        image = new ImageIcon("Pictures/Background1.jpg").getImage();
	        
	        JPanel container = new MyBackground();

	        String text ="Game Developers:\n\n"
	        		+ "Team Coder:\n"
	        		+ "Caig, Alodia\n"
	        		+ "Eleazer, Mark Angelo\n"
	        		+ "Mindanao, Edward Joseph\n"
	        		+ "Oliva, Arvin\n"
	        		+ "Reyes, Jan Darwin\n\n"
	        		+ "Team Designer:\n"
	        		+ "Laila, Kenneth\n"
	        		+ "Pontiveros, Meldy\n\n"
	        		+ "Team Documentation:\n"
	        		+ "Arenas, Karmelo\n"
	        		+ "Merjudio, Jaquelyn\n"
	        		+ "Reyes, Lyden Faye\n\n"
	        		+ "Thanks to the following tutorial:\n"
	        		+ "Fatal Cubez Tutorials\n"
	        		+ "Java 2D Game Tutorial: Side scroll bar game";
	        
	        JTextArea credit = new JTextArea(text);
	        credit.setFont(new Font("Segoe Print", Font.BOLD, 15));
	        credit.setForeground(Color.white);
	        credit.setBackground(null);
	        credit.setEditable(false);
	        
	        backmenu = new JButton("Back To Main Menu");
	        backmenu.setFont(new Font("Courier New", Font.PLAIN, 12));
	        backmenu.setBackground(new Color(148250));
	        backmenu.setForeground(Color.GREEN);
	        backmenu.setUI(new StyledButtonUI());
	        backmenu.addActionListener(this);
	        
	        container.add(credit);
	        
	        add(container);
	        add(backmenu, BorderLayout.SOUTH);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(800,630);
	        setResizable(false);
	        setLocationRelativeTo(null);//to appear in the center
	        setVisible(true);
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
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == backmenu){
				new Buttons().setVisible(true);
				this.dispose();
			}
		}
	}

