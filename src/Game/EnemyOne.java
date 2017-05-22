package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemyOne {
	Image img;
	int x, y;
	boolean isAlive = true;
	
	public EnemyOne(int startX, int startY, String location){
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
		return new Rectangle(x,y,100,75); //boundery of image enemy
	}
	
	

}
