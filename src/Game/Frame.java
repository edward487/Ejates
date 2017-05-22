package Game; //all classes are connected 

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.applet.*;
import javax.swing.*;

import javax.swing.*;

	public class Frame extends JFrame{
	
		public static JFrame frame;
		public Frame(){
			frame = new JFrame("Ejates");
			frame.add(new Board()); //goes to the constructor Board
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 630); //size of background image horizontal, vertical
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);//to appear in the center

			if(Board.isTest() == true)
				frame.dispose();
			
		}
		public static void main(String [] args){
			new Frame();

	
		}
		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
		public void setEnabled(boolean b) {
			// TODO Auto-generated method stub
			
		}



			
}
			