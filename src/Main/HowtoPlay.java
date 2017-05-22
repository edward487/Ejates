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
import javax.swing.JTextArea;

public class HowtoPlay extends JFrame implements ActionListener{

	  public static void main(String[] args) {

	        new HowtoPlay();

	    }
	  
	  private Image image;
	  JButton backmenu;
	  
	  public HowtoPlay() {

	        image = new ImageIcon("Pictures/Background1.jpg").getImage();
	        
	        JPanel container = new MyBackground();

	        String text ="\t\t\teJates: How to play\n\n"+
"eJates is a logic-thinking games that can be solved by using logic gates. The goal of the games is to fire a bullet(0 or 1) \n"
+ "the enemy(logic gates) on what will be the input of the given output. Sounds interesting, right?\n\n"+

"\t\t\teJates: Rules and basics\n"+
"The gun\n"+
"The gun will fire a bullet to the monster(logic gates) that will satisfy to the logic gates.\n"+
"The enemy\n"+
"The enemy is look like logic gates monster that finding what will be the number that is needed.\n"+
"\t\t\tHow to play\n"+
"The rules in eJates are simple:\n"+
"-Fire a right bullet to the feet of the logic gates monster.\n"+
"-Press L for bullet(0) and K for bullet(1). \n"+
"-To move the gun Press W for upward and Press S for downward.\n"+
"-Every kill of the enemy the scores goes up.\n"+
"-Wrong bullet and collision happen to the monster takes 1 lives. There are 3 lives.\n"+
"\t\t\tHints and Tips:\n"+
"-AND GATE MONSTER: 1 and 1 = 1 & 0 and 1 = 0 & 0 and 0 = 0\n"+
"-OR GATE MONSTER: 0 and 1 = 1 & 1 and 1 = 1 & 0 and 0 = 0\n"+
"-NOT GATE MONSTER: 1 = 0 & 0 = 1\n"+
"-NOR GATE MONSTER: 0 and 0 = 1 & 1 and 0 = 0 & 1 and 1 = 0.\n";
	        
	        JTextArea how = new JTextArea(text);
	        how.setFont(new Font("Segoe Print", Font.BOLD, 12));
	        how.setForeground(Color.WHITE);
	        how.setEditable(false);
	        how.setBackground(null);
	        
	        backmenu = new JButton("Back To Main Menu");
	        backmenu.setFont(new Font("Courier New", Font.PLAIN, 12));
	        backmenu.setBackground(new Color(148250));
	        backmenu.setForeground(Color.GREEN);
	        backmenu.setUI(new StyledButtonUI());
	        backmenu.addActionListener(this);
	        backmenu.setBounds(340, 300, 100, 30);
	        
	        container.add(how);
	        container.add(backmenu);
	        
	        add(container);
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

