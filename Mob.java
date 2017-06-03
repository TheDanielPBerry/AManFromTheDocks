package com.first;

import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public class Mob {
	
	private String name = "";
	public boolean hurt = false;
	private Image image;
	private Point pos;
	private String message = "";
	private byte health = 10;
	public Point pp = new Point(0,0);
	
	public Mob(byte id, Point p) {
		if(id==0) {
			name = "orc";
			hurt = true;
		}
		image = new ImageIcon("res\\images\\" + name + ".png").getImage();
		pos=p;
	}
	public Mob(byte id, Point p, String m) {
		if(id==0) {
			name = "orc";
		}
		if(id==1) {
			name = "granny";
			message = m;
		}
		if(id==2) {
			name = "sarah";
			message = m;
		}
		if(id==3) {
			name = "knight";
			message = m;
		}
		if(id==4) {
			name = "king";
			message = m;
		}
		if(id==5) {
			name = "ian";
			message = m;
		}
		if(id==6) {
			name = "professor";
			message = m;
		}
		if(id==7) {
			name = "edward";
			message = m;
		}
		if(id==8) {
			name = "sailor";
			message = m;
		}
		if(id==9) {
			name = "fieldhand";
			message = m;
		}
		if(id==10) {
			name = "pirate";
			message = m;
		}
		if(id==11) {
			name = "thug";
			message = m;
		}
		if(id==12) {
			name = "barkeep";
			message = m;
		}if(id==13) {
			hurt = true;
			health = 60;
			name = "ian";
			message = m;
		}if(id==14) {
			health = 30;
			name = "guardian";
			message = m;
		}
		
		image = new ImageIcon("res\\images\\" + name + ".png").getImage();
		pos = p;
	}
	public Mob(byte id, Point p, Point mP) {
		if(id==14) {
			hurt = true;
			name = "fireball";
			pp = mP;
			image = new ImageIcon("res\\images\\" + name + ".png").getImage();
			pos = p;
		}
	}
	public Image getImage() {
		return image;
	}
	public int getX() {
		return pos.x;
	}
	public int getY() {
		return pos.y;
	}
	public void setPos(Point p) {
		pos.x+=p.x;
		pos.y+=p.y;
		pp.x+=p.x;
		pp.y+=p.y;
	}
	public String getMessage() {
		
		return message;
	}
	
	public void damage() {
		if(name!="ian") {
			rebound();
			health-=4;
			if(name=="guardian" && health<10) {
				image = new ImageIcon("res\\images\\hurtguardian.png").getImage();
			}
		}else {
			health-=10;
		}
	}
	public void strikedamage() {
		if(name!="ian") {
			rebound();
			health-=10;
			if(name=="guardian" && health<10) {
				image = new ImageIcon("res\\images\\hurtguardian.png").getImage();
			}
		}else {
			health-=10;
		}
	}
	Random r= new Random();
	public byte getHealth() {
		return health;
	}
	private boolean allow = true;
	
	public void activate() {
		if(name=="ian") {
			if(pos.x<300) {
				allow = false;
			}if(pos.x>500) {
				allow = true;
			}
			if(allow) {
				pos.x-=1;
			}else if(!allow) {
				pos.x+=1;
			}
		}else if(name=="fireball") { 
			if(pos.x<pp.x) {
				pos.x+=4;
			}else {
				pos.x-=4;
			}
			pos.y+=4;
		}else { 
			if(pos.x<400) {
				pos.x+=2;
			}else {
				pos.x-=2;
			}if(pos.y<300) {
				pos.y+=2;
			}else {
				pos.y-=2;
			}
		}
	}
	public void rebound() {
		pos.x-=(400-pos.x);
		pos.y-=(320-pos.y);
	}
	public void reboundHalf() {
		pos.x-=(400-pos.x)/2;
		pos.y-=(320-pos.y)/2;
	}
	public String getName() {
		
		return name;
	}
}
