package Game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

import Main.Buttons;
import Main.Menu;

import javax.swing.*;

import org.omg.CORBA.portable.InputStream;

public class Board extends JPanel implements ActionListener, Runnable{
	//instance of new class 
	Gun p;
	Image img; //contains of background image
	Timer time; //
	int v = 172;
	public static boolean test = false;
	public static boolean isTest() {
		return test;
	}
	public static void setTest(boolean test) {
		Board.test = test;
	}

	Thread animator;
	EnemyZero enZero[] = new EnemyZero[60];
	EnemyOne enOne[] = new EnemyOne[60];
	EnemyAny enAny[] = new EnemyAny[60];
	int score=0;
	int lives = 3;
	
	boolean lost = false;   // if enemy hits the player the player lost
	boolean h = false;
	boolean done = false;
	boolean exit = false;
	
	static Font font = new Font("SanSerif",Font.BOLD, 24);
	public Board(){
		p = new Gun(); //start of running the Gun class
		addKeyListener(new AL()); 
		setFocusable(true); //allows key when pressing key so its move left to right
		ImageIcon i = new ImageIcon("Pictures/test.png");  //setting image
		img = i.getImage(); //img stores the background image
		
		time = new Timer(5, this); //every 5ms the image will update
		time.start(); //runs method for the ActionPerformed
		

		//en is the variable that store the picture of enemy
		enOne[0] = new EnemyOne(400, 200, "Pictures/enemies/EnemyOne/1.png");
		enOne[1] = new EnemyOne(15000, 500, "Pictures/enemies/EnemyOne/3.png");
		enOne[2] = new EnemyOne(24500, 300, "Pictures/enemies/EnemyOne/4.png");
		enOne[3] = new EnemyOne(35000, 100, "Pictures/enemies/EnemyOne/6.png");
		enOne[4] = new EnemyOne(29000, 600, "Pictures/enemies/EnemyOne/2.png");
		enOne[5] = new EnemyOne(1300, 400, "Pictures/enemies/EnemyOne/7.png");
		enOne[6] = new EnemyOne(33333, 100, "Pictures/enemies/EnemyOne/2.png");
		enOne[7] = new EnemyOne(4900, 300, "Pictures/enemies/EnemyOne/8.png");
		enOne[8] = new EnemyOne(6500, 100, "Pictures/enemies/EnemyOne/5.png");
		enOne[9] = new EnemyOne(42000, 400, "Pictures/enemies/EnemyOne/1.png");
		enOne[10] = new EnemyOne(45000, 100, "Pictures/enemies/EnemyOne/6.png");
		enOne[11] = new EnemyOne(7100, 300, "Pictures/enemies/EnemyOne/3.png");
		enOne[12] = new EnemyOne(10700, 300, "Pictures/enemies/EnemyOne/8.png");
		enOne[13] = new EnemyOne(8000, 300, "Pictures/enemies/EnemyOne/8.png");
		enOne[14] = new EnemyOne(12000, 100, "Pictures/enemies/EnemyOne/5.png");
		enOne[15] = new EnemyOne(32789, 400, "Pictures/enemies/EnemyOne/1.png");
		enOne[16] = new EnemyOne(34543, 500, "Pictures/enemies/EnemyOne/7.png");
		enOne[17] = new EnemyOne(9809, 300, "Pictures/enemies/EnemyOne/5.png");
		enOne[18] = new EnemyOne(33333, 600, "Pictures/enemies/EnemyOne/8.png");
		enOne[19] = new EnemyOne(22000, 300, "Pictures/enemies/EnemyOne/8.png");
		
		enZero[0] = new EnemyZero(47000, 100, "Pictures/enemies/EnemyZero/1.png");
		enZero[1] = new EnemyZero(2850, 500, "Pictures/enemies/EnemyZero/7.png");
		enZero[2] = new EnemyZero(48000, 300, "Pictures/enemies/EnemyZero/6.png");
		enZero[3] = new EnemyZero(7300, 100, "Pictures/enemies/EnemyZero/4.png");
		enZero[4] = new EnemyZero(20000, 600, "Pictures/enemies/EnemyZero/2.png");
		enZero[5] = new EnemyZero(2450, 400, "Pictures/enemies/EnemyZero/4.png");
		enZero[6] = new EnemyZero(28000, 100, "Pictures/enemies/EnemyZero/2.png");
		enZero[7] = new EnemyZero(36000, 300, "Pictures/enemies/EnemyZero/3.png");
		enZero[8] = new EnemyZero(52000, 100, "Pictures/enemies/EnemyZero/7.png");
		enZero[9] = new EnemyZero(37689, 400, "Pictures/enemies/EnemyZero/2.png");
		enZero[10] = new EnemyZero(17000, 100, "Pictures/enemies/EnemyZero/1.png");
		enZero[11] = new EnemyZero(1800, 300, "Pictures/enemies/EnemyZero/3.png");
		enZero[12] = new EnemyZero(41000, 500, "Pictures/enemies/EnemyZero/4.png");
		enZero[13] = new EnemyZero(28000, 100, "Pictures/enemies/EnemyZero/2.png");
		enZero[14] = new EnemyZero(37500, 300, "Pictures/enemies/EnemyZero/3.png");
		enZero[15] = new EnemyZero(19000, 100, "Pictures/enemies/EnemyZero/1.png");
		enZero[16] = new EnemyZero(34500, 400, "Pictures/enemies/EnemyZero/2.png");
		enZero[17] = new EnemyZero(17000, 100, "Pictures/enemies/EnemyZero/1.png");
		enZero[18] = new EnemyZero(22222, 300, "Pictures/enemies/EnemyZero/3.png");
		enZero[19] = new EnemyZero(29000, 500, "Pictures/enemies/EnemyZero/4.png");
		
		
		enAny[0] = new EnemyAny(1111, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[1] = new EnemyAny(47000, 500, "Pictures/enemies/EnemyAny/1.png");
		enAny[2] = new EnemyAny(8300, 300, "Pictures/enemies/EnemyAny/1.png");
		enAny[3] = new EnemyAny(33000, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[4] = new EnemyAny(6700, 600, "Pictures/enemies/EnemyAny/1.png");
		enAny[5] = new EnemyAny(43500, 400, "Pictures/enemies/EnemyAny/1.png");
		enAny[6] = new EnemyAny(15550, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[7] = new EnemyAny(32000, 300, "Pictures/enemies/EnemyAny/1.png");
		enAny[8] = new EnemyAny(55555, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[9] = new EnemyAny(27000, 400, "Pictures/enemies/EnemyAny/1.png");
		enAny[10] = new EnemyAny(1589, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[11] = new EnemyAny(30000, 300, "Pictures/enemies/EnemyAny/1.png");
		enAny[12] = new EnemyAny(700, 400, "Pictures/enemies/EnemyAny/1.png");
		enAny[13] = new EnemyAny(11000, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[14] = new EnemyAny(31000, 300, "Pictures/enemies/EnemyAny/1.png");
		enAny[15] = new EnemyAny(1234, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[16] = new EnemyAny(41457, 400, "Pictures/enemies/EnemyAny/1.png");
		enAny[17] = new EnemyAny(27000, 100, "Pictures/enemies/EnemyAny/1.png");
		enAny[18] = new EnemyAny(18000, 300, "Pictures/enemies/EnemyAny/1.png");
		enAny[19] = new EnemyAny(5000, 300, "Pictures/enemies/EnemyAny/1.png");
		
		
	}
	public void actionPerformed(ActionEvent e){
		checkCollisions();// to check the collisions constantly
		//System.out.println(p.x);
		// its the storage of the bullet methods
		ArrayList<Bullet> bullets = Gun.getBullets();
		for(int w = 0; w<bullets.size(); w++){
			Bullet m = (Bullet)bullets.get(w);
			if(m.getVisible() == true){
			m.move();
			}
			else{
				bullets.remove(w);
			}
		}
		
		ArrayList<Bullet0> bullets0 = Gun.getBullets0();
		for(int w = 0; w<bullets0.size(); w++){
			Bullet0 m = (Bullet0)bullets0.get(w);
			if(m.getVisible() == true){
			m.move();
			}	
			else{
				bullets0.remove(w);
			}
		}
		
		p.move();
		
		for (int i=0; i<19; i++){
			if(p.x > 300) {
				enOne[i].move(p.dx);
				enZero[i].move(p.dx);
				enAny[i].move(p.dx);
			}
		}
		
		repaint(); //repaint every 5ms
	}
	
	boolean k = false;
	
	public void checkCollisions(){// this check if all bullet collide to enemy
		 
		Rectangle rOne[] = new Rectangle[20];
		Rectangle rZero[] = new Rectangle[20];
		Rectangle rAny[] = new Rectangle[20];
		//Object for EnemyOne
		for(int i=0; i<20; i++) {
			
			try {
				rOne[i] = enOne[i].getBounds();
			} 
			catch (NullPointerException e) {
				System.out.println("Null Object "+ i);
			}
		}

		//Object for EnemyZero
		for(int i=0; i<20; i++) {
			
			try {
				rZero[i] = enZero[i].getBounds();
			} 
			catch (NullPointerException e) {
				System.out.println("Null Object "+ i);
			}
		}

		//Object for EnemyAny
		for(int i=0; i<20; i++) {
			
			try {
				rAny[i] = enAny[i].getBounds();
			} 
			catch (NullPointerException e) {
				System.out.println("Null Object "+ i);
			}
		}

		//For Bullet One
		ArrayList<Bullet> bullets = Gun.getBullets();
		
		for (int i = 0; i<bullets.size(); i++){
			
			Bullet m = (Bullet)bullets.get(i);
			Rectangle m1 = m.getBounds();
			
			for(int j = 0; j<20; j++){
				if(rOne[j].intersects(m1) && enOne[j].Alive()) {
					enOne[j].isAlive = false;
					m.visible = false;
					score+= 1;
				}
			}
		}
		
		for (int i = 0; i<bullets.size(); i++){
			
			Bullet m = (Bullet)bullets.get(i);
			Rectangle m1 = m.getBounds();
			
			for(int j = 0; j<20; j++){
				if(rZero[j].intersects(m1) && enZero[j].Alive()) {
					lives--;
					m.visible = false;
					if(lives <= 0)
						lost = true;
				}
			}
		}

		for (int i = 0; i<bullets.size(); i++){
			
			Bullet m = (Bullet)bullets.get(i);
			Rectangle m1 = m.getBounds();
			
			for(int j = 0; j<20; j++){
				if(rAny[j].intersects(m1) && enAny[j].Alive()) {
					enAny[j].isAlive = false;
					m.visible = false;
					score++;
				}
			}
		}
		
		//For Bullet Zero
		ArrayList<Bullet0> bullets0 = Gun.getBullets0();
		
		for (int i = 0; i<bullets0.size(); i++){
			
			Bullet0 m = (Bullet0)bullets0.get(i);
			Rectangle m1 = m.getBounds();
			
			for(int j = 0; j<20; j++){
				if(rOne[j].intersects(m1) && enOne[j].Alive()) {
					lives--;
					m.visible = false;
					if(lives <= 0){
						lost = true;
						
						
					}
				}
			}
		}   
		
		for (int i = 0; i<bullets0.size(); i++){
			
			Bullet0 m = (Bullet0)bullets0.get(i);
			Rectangle m1 = m.getBounds();
			
			for(int j = 0; j<20; j++){
				if(rZero[j].intersects(m1) && enZero[j].Alive()) {
					enZero[j].isAlive = false;
					m.visible = false;
					score++;
				}
			}
		}
		
		for (int i = 0; i<bullets0.size(); i++){
			
			Bullet0 m = (Bullet0)bullets0.get(i);
			Rectangle m1 = m.getBounds();
			
			for(int j = 0; j<20; j++){
				if(rAny[j].intersects(m1) && enAny[j].Alive()) {
					enAny[j].isAlive = false;
					m.visible = false;
					score++;
				}
			}
		}
		
		Rectangle d = p.getBounds();
		
		for(int i = 0; i<20; i++) {
			if(d.intersects(rOne[i]) && enOne[i].Alive()) {
				enOne[i].isAlive = false;
				lives--;
				if(lives <= 0)
					lost = true;
				
			}
		}
		
		for(int i = 0; i<20; i++) {
			if(d.intersects(rZero[i]) && enZero[i].Alive()) {
				enZero[i].isAlive = false;
				lives--;
				if(lives <= 0)
					lost = true;
			}
		}
		
		for(int i = 0; i<20; i++) {
			if(d.intersects(rAny[i]) && enAny[i].Alive()) {
				enAny[i].isAlive = false;
				lives--;
				if(lives <= 0)
					lost = true;
				
				
			}
		}
		
		
	}
	
	//its draw all the  image if the image move to right or left and check if the enemy is alive or not
	public void paint(Graphics g){
		if (lost){
			if(lives == 0){
				exit = true;
				lost = false;
				test = true;
				if(exit==true){
					test = true;
					new Menu().setVisible(true);
					
					
				
				}
				
			}
			exit = false;
		} 
		 if(p.dy == 1 && k == false){ //determines when animation starts
			 k = true;
			 animator = new Thread(this);
			 animator.start(); //start when p.dy is 1
		 }
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g; //2d graphics
		if((p.getX()) % 45000 == 0)  // position  of background
			p.nx = 0;
		
		if((p.getX()-24000) % 45000 == 0) 
			p.nx2 = 0;
		
		g2d.drawImage(img, -p.nx2, 0, null);
		System.out.println(p.getX()); //check what point exactly is 
		
		if(p.getX() >= 0){ //0 is the exact point of background 
			g2d.drawImage(img, -p.nx, 0 , null);
		}
		g2d.drawImage(p.getImage(), p.left, p.y, null ); //to get the character
		
		ArrayList<Bullet> bullets = Gun.getBullets();
		for(int w = 0; w<bullets.size(); w++){
			
			Bullet m = (Bullet)bullets.get(w);
			g2d.drawImage(m.getImage(),m.getX(),m.getY(), null);
		}
		ArrayList<Bullet0> bullets0 = Gun.getBullets0();
		for(int w = 0; w<bullets0.size(); w++){
			
			Bullet0 m = (Bullet0)bullets0.get(w);
			g2d.drawImage(m.getImage(),m.getX(),m.getY(), null);
		}

		if(p.x > 400){
			if(enOne[0].Alive() == true){
				g2d.drawImage(enOne[0].getImage(), enOne[0].getX(), enOne[0].getY(), null);
				
			}
		}
		
		if(p.x > 400){
				if(enOne[1].Alive() == true){
					g2d.drawImage(enOne[1].getImage(), enOne[1].getX(), enOne[1].getY(),null);
					
				}
				
		}
		if(p.x > 400){
			if(enOne[2].Alive() == true){
				g2d.drawImage(enOne[2].getImage(), enOne[2].getX(), enOne[2].getY(),null);
				
			}
			
	}
			

		if(p.x > 400){
			if(enOne[3].Alive() == true){
				g2d.drawImage(enOne[3].getImage(), enOne[3].getX(), enOne[3].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enOne[4].Alive() == true){
				g2d.drawImage(enOne[4].getImage(), enOne[4].getX(), enOne[4].getY(),null);
				
			}
			
	}
			

		if(p.x > 400){
			if(enOne[5].Alive() == true){
				g2d.drawImage(enOne[5].getImage(), enOne[5].getX(), enOne[5].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[6].Alive() == true){
				g2d.drawImage(enOne[6].getImage(), enOne[6].getX(), enOne[6].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[7].Alive() == true){
				g2d.drawImage(enOne[7].getImage(), enOne[7].getX(), enOne[7].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[8].Alive() == true){
				g2d.drawImage(enOne[8].getImage(), enOne[8].getX(), enOne[8].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[9].Alive() == true){
				g2d.drawImage(enOne[9].getImage(), enOne[9].getX(), enOne[9].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[10].Alive() == true){
				g2d.drawImage(enOne[10].getImage(), enOne[10].getX(), enOne[10].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[11].Alive() == true){
				g2d.drawImage(enOne[11].getImage(), enOne[11].getX(), enOne[11].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[12].Alive() == true){
				g2d.drawImage(enOne[12].getImage(), enOne[12].getX(), enOne[12].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enOne[13].Alive() == true){
				g2d.drawImage(enOne[13].getImage(), enOne[13].getX(), enOne[13].getY(),null);
				
			}
			
	}
			

		if(p.x > 400){
			if(enOne[14].Alive() == true){
				g2d.drawImage(enOne[14].getImage(), enOne[14].getX(), enOne[14].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[15].Alive() == true){
				g2d.drawImage(enOne[15].getImage(), enOne[15].getX(), enOne[15].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[16].Alive() == true){
				g2d.drawImage(enOne[16].getImage(), enOne[16].getX(), enOne[16].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[17].Alive() == true){
				g2d.drawImage(enOne[17].getImage(), enOne[17].getX(), enOne[17].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[18].Alive() == true){
				g2d.drawImage(enOne[18].getImage(), enOne[18].getX(), enOne[18].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enOne[19].Alive() == true){
				g2d.drawImage(enOne[19].getImage(), enOne[19].getX(), enOne[19].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enZero[12].Alive() == true){
				g2d.drawImage(enZero[12].getImage(), enZero[12].getX(), enZero[12].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enZero[0].Alive() == true){
				g2d.drawImage(enZero[0].getImage(), enZero[0].getX(),enZero[0].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[1].Alive() == true){
				g2d.drawImage(enZero[1].getImage(), enZero[1].getX(), enZero[1].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[2].Alive() == true){
				g2d.drawImage(enZero[2].getImage(), enZero[2].getX(), enZero[2].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[3].Alive() == true){
				g2d.drawImage(enZero[3].getImage(), enZero[3].getX(), enZero[3].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[4].Alive() == true){
				g2d.drawImage(enZero[4].getImage(), enZero[4].getX(), enZero[4].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[5].Alive() == true){
				g2d.drawImage(enZero[5].getImage(), enZero[5].getX(), enZero[5].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enZero[6].Alive() == true){
				g2d.drawImage(enZero[6].getImage(), enZero[6].getX(), enZero[6].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[7].Alive() == true){
				g2d.drawImage(enZero[7].getImage(), enZero[7].getX(), enZero[7].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[8].Alive() == true){
				g2d.drawImage(enZero[8].getImage(), enZero[8].getX(), enZero[8].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[9].Alive() == true){
				g2d.drawImage(enZero[9].getImage(), enZero[9].getX(), enZero[9].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[10].Alive() == true){
				g2d.drawImage(enZero[10].getImage(), enZero[10].getX(), enZero[10].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[11].Alive() == true){
				g2d.drawImage(enZero[11].getImage(), enZero[11].getX(), enZero[11].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[12].Alive() == true){
				g2d.drawImage(enZero[12].getImage(), enZero[12].getX(), enZero[12].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enZero[13].Alive() == true){
				g2d.drawImage(enZero[13].getImage(), enZero[13].getX(), enZero[13].getY(),null);
				
			}
			
	}
			

		if(p.x > 400){
			if(enZero[14].Alive() == true){
				g2d.drawImage(enZero[14].getImage(), enZero[14].getX(), enZero[14].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[15].Alive() == true){
				g2d.drawImage(enZero[15].getImage(), enZero[15].getX(), enZero[15].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[16].Alive() == true){
				g2d.drawImage(enZero[16].getImage(), enZero[16].getX(), enZero[16].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[17].Alive() == true){
				g2d.drawImage(enZero[17].getImage(), enZero[17].getX(), enZero[17].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[18].Alive() == true){
				g2d.drawImage(enZero[18].getImage(), enZero[18].getX(), enZero[18].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enZero[19].Alive() == true){
				g2d.drawImage(enZero[19].getImage(), enZero[19].getX(), enZero[19].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enAny[0].Alive() == true){
				g2d.drawImage(enAny[0].getImage(), enAny[0].getX(),enAny[0].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[1].Alive() == true){
				g2d.drawImage(enAny[1].getImage(), enAny[1].getX(), enAny[1].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[2].Alive() == true){
				g2d.drawImage(enAny[2].getImage(), enAny[2].getX(), enAny[2].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[3].Alive() == true){
				g2d.drawImage(enAny[3].getImage(), enAny[3].getX(), enAny[3].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[4].Alive() == true){
				g2d.drawImage(enAny[4].getImage(), enAny[4].getX(), enAny[4].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[5].Alive() == true){
				g2d.drawImage(enAny[5].getImage(), enAny[5].getX(), enAny[5].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enAny[6].Alive() == true){
				g2d.drawImage(enAny[6].getImage(), enAny[6].getX(), enAny[6].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[7].Alive() == true){
				g2d.drawImage(enAny[7].getImage(), enAny[7].getX(), enAny[7].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[8].Alive() == true){
				g2d.drawImage(enAny[8].getImage(), enAny[8].getX(), enAny[8].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[9].Alive() == true){
				g2d.drawImage(enAny[9].getImage(), enAny[9].getX(), enAny[9].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[10].Alive() == true){
				g2d.drawImage(enAny[10].getImage(), enAny[10].getX(), enAny[10].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[11].Alive() == true){
				g2d.drawImage(enAny[11].getImage(), enAny[11].getX(), enAny[11].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[12].Alive() == true){
				g2d.drawImage(enAny[12].getImage(), enAny[12].getX(), enAny[12].getY(),null);
				
			}
			
	}
		
		if(p.x > 400){
			if(enAny[13].Alive() == true){
				g2d.drawImage(enAny[13].getImage(), enAny[13].getX(), enAny[13].getY(),null);
				
			}
			
	}
			

		if(p.x > 400){
			if(enAny[14].Alive() == true){
				g2d.drawImage(enAny[14].getImage(), enAny[14].getX(), enAny[14].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[15].Alive() == true){
				g2d.drawImage(enAny[15].getImage(), enAny[15].getX(), enAny[15].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[16].Alive() == true){
				g2d.drawImage(enAny[16].getImage(), enAny[16].getX(), enAny[16].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[17].Alive() == true){
				g2d.drawImage(enAny[17].getImage(), enAny[17].getX(), enAny[17].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[18].Alive() == true){
				g2d.drawImage(enAny[18].getImage(), enAny[18].getX(), enAny[18].getY(),null);
				
			}
			
	}
		if(p.x > 400){
			if(enAny[19].Alive() == true){
				g2d.drawImage(enAny[19].getImage(), enAny[19].getX(), enAny[19].getY(),null);
				
			}
			
	}
		g2d.setFont(font);
		g2d.setColor(Color.BLUE);
		g2d.drawString("Lives"+ " " +lives, 100, 20);
		g2d.drawString("Score: "+ score, 500, 20);
	}
	
	//determines which key was press  
	private class AL extends KeyAdapter{
		public void keyReleased(KeyEvent e){  //when key is RELEASED
			p.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){ //when key is PRESSED 
			p.keyPressed(e);
		}
		
	}

	@Override
	public void run() {  //run when animation starts 
		
		long beforeTime, timeDiff, sleep; 
		beforeTime = System.currentTimeMillis();
		while(done == false){
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 10 - timeDiff;
			if(sleep < 0){
				sleep = 2;
			}
			try{
				Thread.sleep(sleep);
			}catch(Exception e)
			{}
			beforeTime = System.currentTimeMillis();
		}
		done = false;
		h = false;
		k = false;
		
	}
	
}
	


