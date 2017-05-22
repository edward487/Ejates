package Game;
import java.awt.*;

import javax.swing.*;

public class Bullet0 {
	int x, y;
	Image img;
	boolean visible;
	
	public Bullet0(int startX, int startY){
		
		x = startX;
		y = startY;
		ImageIcon bllet = new ImageIcon("Pictures/Bullet/0.png");
		img = bllet.getImage();
		visible = true;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,37,25);//getting bounds of enemy
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean getVisible(){
		return visible;
	}
	public Image getImage(){
		return img;
	}
	public void move(){
		x = x + 2;
		if( x > 800){
			visible = false;
		}
	}
}
