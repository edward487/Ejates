package Game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

public class Gun {
	int x, y, nx2, left, top, v; // x   for holds x coordinate ; dx for change in x ; y for y coordinates ;
	 public int ny, nx, dy, ny2, dx;
	
	Image gun;
	
	int ammo = 5;
	ImageIcon i = new ImageIcon("Pictures/gun.png");
	
	boolean lost = false;   // if enemy hit the player the player lost
	boolean h = false;
	boolean done = false;
	
	 /*URL fireZeroUrl=Gun.class.getResource("fireZero.mp3");
	 AudioClip fireZero=Applet.newAudioClip(fireZeroUrl);
	 URL fireOneUrl=Gun.class.getResource("fireOne.mp3");
	 AudioClip fireOne=Applet.newAudioClip(fireOneUrl);*/
	
static ArrayList<Bullet> bullets; //holds all bullets we have 
static ArrayList<Bullet0> bullets0; //holds all bullets we have 
public Gun(){
	left = 5; // position of the character
	top = 50;
	gun = i.getImage();
	x = 75;
	nx2 = 0; //the second appearance of background
	ny2 = 0;
	nx = 0;
	ny = 0;
	y = 50;
	dx += 1;
	bullets = new ArrayList<Bullet>();
	bullets0 = new ArrayList<Bullet0>();
}

	public Rectangle getBounds()
	{
	return new Rectangle(left,y,100,108); //boundery of picture GUN

	}


	public static ArrayList<Bullet> getBullets(){
	return bullets;
}
	public static ArrayList<Bullet0> getBullets0(){
	return bullets0;
}
	public void fire(){// bullets count
	if(ammo > 0){
		

	Bullet z = new Bullet(left+95, y+48); // position of the bullets at the center of the gun
	 bullets.add(z);
	// fireOne.play();
	}
	}
	public void fire0(){// bullets count
	if(ammo > 0){
		

	Bullet0 x = new Bullet0((left+95), y+48); // position of the bullets at the center of the gun
	 bullets0.add(x);
	// fireZero.play();
	}
		
	
}

public void move(){
	if(dy != - 1){//down
		if(y == 507) //if the gun reaches the lower limit the down() will not function
			h = true;
			if(h != true){
				down();
				x = x + dx; // x plus the amount we move 
				nx2 = nx2 + dx;
				nx = nx + dx; //the background will move as we move the gun
			}else{
				up();
				x = x + dx; // x plus the amount we move 
				nx2 = nx2 + dx;
				nx = nx + dx; //the background will move as we move the gun
				h = false;
			}
		}
	
	else if(dy != 1){//dy = -1 up
		if(y == -10) // if the gun reaches the upper limit the up() will not funtion 
			h = true;
			if(h != true){
				up();
				x = x + dx; // moving forward while moving up
				nx2 = nx2 + dx;
				nx = nx + dx;
			}else{
				down();
				x = x + dx; 
				nx2 = nx2 + dx;
				nx = nx + dx;
				h = false;
			}	 
		}
}

private void up() { // up function
	if(dy<0)
		y += (dy-1);
		ny2 += dy;
		ny += dy;
		}

private void down(){ //down function
	if(dy>0){
		y += (dy+1);
		ny2 += dy;
		ny += dy;
	}
}


//the variables are not static so it needs to access in other method like this 
public int getX(){   
	return x;
}
public int getY(){
	return y;
}

public Image getImage(){ 
	return gun;
}

public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	if(key == KeyEvent.VK_S){
	dy = 1; //movement in down
	gun = i.getImage();
	
	}
	if (key == KeyEvent.VK_W){
		dy = -1; // move up
		gun = i.getImage();
	}
	if(key == KeyEvent.VK_K){
		fire();
	//	fireOne.play();
	}
	if(key == KeyEvent.VK_L){
		fire0();
		//fireZero.play();
	}
	
}
public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();

	if(key == KeyEvent.VK_S){
	dy = 0;
	gun = i.getImage();
	}
	if(key == KeyEvent.VK_W){
		dy = 0;
		gun = i.getImage();
	}
}

}
