 package Game;

import java.awt.*;

import javax.swing.*;

public class Enemies {
	Image img;
	int x, y;
	boolean isAlive = true;
	
	public Enemies(int startX, int startY, String location){
		x = startX;
		y = startY;
		ImageIcon l = new ImageIcon(location);
		img = l.getImage();
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean Alive(){
		return isAlive;
	}
	public Image getImage(){
		return img;
	}
	public void move(int dx){
		x = x - dx;
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,64,100); //boundery of image enemy
	}
	
}

