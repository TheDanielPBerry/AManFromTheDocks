package com.first;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Article {
	
	private String name;
	public boolean collide = false;
	private Point pos;
	private Image image;
	private String message = "";
	private byte od = 0;
	private byte stoneId = 0;
	
	public Article(byte id, Point p) {
		if(id==0) {
			name = "grass";
		}else if(id==2) {
			name = "rock";
		}else if(id==3) {
			name = "stone";
		}else if(id==4) {
			name = "tree";
			collide = true;
		}else if(id==5) {
			name = "tree32";
			collide = true;
		}else if(id==6) {
			name = "wood";
		}else if(id==7) {
			name = "dockPeg";
			collide = true;
		}else if(id==8) {
			name = "water2";
			collide = true;
		}else if(id==9) {
			name = "rockWater";
			collide = true;
		}else if(id==10) {
			name = "lava";
			collide = true;
		}else if(id==11) {
			name = "bricks";
		}else if(id==12) {
			name = "stonebricks";
			collide = true;
		}else if(id==13) {
			od=id;
			name = "house";
			collide = true;
		}else if(id==14) {
			name = "path";
		}else if(id==15) {
			name = "sign";
			collide = true;
		}else if(id==16) {
			name = "bush";
		}else if(id==17) {
			name = "wheat";
			collide = true;
		}else if(id==18) {
			name = "fence";
			collide = true;
		}else if(id==19) {
			od=id;
			name = "door";
			collide = true;
		}else if(id==20) {
			name = "castle";
			collide = true;
		}else if(id==21) {
			name = "sand";
		}else if(id==22) {
			//Declin's House
			name = "house";
			od=id;
			collide = true;
		}else if(id==24) {
			name = "shipport";
			collide = true;
		}else if(id==25) {
			name = "craggle";
			collide = true;
		}else if(id==26) {
			name = "shack";
			collide = true;
		}else if(id==27) {
			name = "shop";
			collide = true;
		}else if(id==28) {
			name = "tile";
		}else if(id==30) {
			name = "shipwreck";
			collide = true;
		}else if(id==31) {
			name = "spike";
			collide = true;
		}else if(id==32) {
			name = "void";
			collide = true;
		}else if(id==33) {
			name = "castleTile";
		}else if(id==34) {
			od=34;
			name = "voiddoor";
			collide = true;
		}else if(id==35) {
			name = "housetile";
		}else if(id==36) {
			name = "couch";
			collide=true;
		}else if(id==37) {
			od=id;
			name = "house";
			collide=true;
		}else if(id==38) {
			name = "door";
			collide = true;
		}else if(id==39) {
			name = "throne";
		}else if(id==40) {
			name = "voiddoor";
			collide = true;
		}else if(id==41) {
			name = "voiddoor";
			collide = true;
		}else if(id==42) {
			name = "voiddoor";
			collide = true;
		}else if(id==43) {
			name = "voiddoor";
			collide = true;
		}else if(id==44) {
			name = "mark";
			collide = true;
		}else if(id==45) {
			name = "telly";
			collide = true;
		}else if(id==46) {
			name = "bar";
			collide = true;
		}else if(id==47) {
			name = "cascadeTile";
		}
		od=id;
		pos = p;
		if(name == "water2") image = new ImageIcon("res\\images\\" + name + ".gif").getImage();
		else image = new ImageIcon("res\\images\\" + name + ".png").getImage();
	}
	
	//chest
	public Article(byte id, Point p, String m) {
		if(id==15) {
			name = "sign";
			collide=true;
			message = m;
		}
		pos = p;
		image = new ImageIcon("res\\images\\" + name + ".png").getImage();
	}
	public Article(byte id, Point p, boolean open, String item) {
		if(id==23) {
			name = "chest";
		}
		pos = p;
		image = new ImageIcon("res\\images\\" + name + ".png").getImage();
	}
	public Article(byte id, Point p, byte stone) {
		if(id==29) {
			name = "inscription";
			collide = true;
			stoneId = stone;
		}
		od=id;
		pos = p;
		image = new ImageIcon("res\\images\\" + name + ".png").getImage();
	}
	
	public int getX() {
		return pos.x;
	}
	public int getY() {
		return pos.y;
	}
	public Image getImage() {
		return image;
	}
	public void setPos(Point p) {
		pos.x+=p.x;
		pos.y+=p.y;
	}
	public String getName() {
		return name;
	}
	public Map activate() {
		if(od==22) {
			ArrayList<Article> arts = new ArrayList<Article>();
			arts.add(new Article((byte) 40, new Point(15*32, 23*32)));
			arts.add(new Article((byte)36, new Point(13*32, 14*32)));
			arts.add(new Article((byte)45, new Point(15*32, 16*32)));
			Map m = new House(arts);
			m.setPos(new Point(-6,-13));
			return m;
		}
		if(od==13) {
			ArrayList<Article> arts = new ArrayList<Article>();
			arts.add(new Article((byte) 41, new Point(15*32, 23*32)));
			Map m = new House(arts);
			m.setPos(new Point(-6,-13));
			return m;
		}
		if(od==37) {
			ArrayList<Article> arts = new ArrayList<Article>();
			arts.add(new Article((byte) 42, new Point(15*32, 23*32)));
			ArrayList<Mob> mobs = new ArrayList<Mob>();
			mobs.add(new Mob((byte)2, new Point(15*32,13*32), ""));
			mobs.add(new Mob((byte)6, new Point(13*32,18*32), "Professor: Declin you must hurry to the king to seek aid to save Sar-ah from this horrible fiend, Ian. You must find a guide to take you to The Cascade to retrieve Falgoric's Rod first in ordr for you to beat him.."));
			mobs.add(new Mob((byte)5, new Point(15*32,15*32), ""));
			Map m = new House(arts, mobs);
			m.setPos(new Point(-6,-13));
			Main.cutscene1=true;
			return m;
		}if(od==19) {
			Map m = new Castle();
			m.setPos(new Point(-7,-25));
			return m;
		}if(od==34) {
			Map m = new Teremona();
			m.setPos(new Point(-8,-13));
			return m;
		}if(od==40) {
			Map m = new Teremona();
			m.setPos(new Point(-50,-13));
			return m;
		}if(od==41) {
			Map m = new Teremona();
			m.setPos(new Point(-55,-16));
			return m;
		}if(od==42) {
			Map m = new Teremona();
			m.setPos(new Point(-45,-10));
			return m;
		}if(od==43) {
			Map m = new Baduz();
			m.setPos(new Point(-24,-24));
			return m;
		}if(od==27) {
			ArrayList<Article> arts = new ArrayList<Article>();
			arts.add(new Article((byte) 43, new Point(15*32, 23*32)));
			arts.add(new Article((byte)36, new Point(11*32, 14*32)));
			arts.add(new Article((byte)45, new Point(12*32, 16*32)));
			arts.add(new Article((byte)46, new Point(22*32, 15*32)));
			ArrayList<Mob> mobs = new ArrayList<Mob>();
			mobs.add(new Mob((byte)12, new Point(24*32,13*32), "Barkeep: Sorry mate. Fresh out of booze."));
			mobs.add(new Mob((byte)7, new Point(18*32,15*32), "Edward: So you need a guide into The Cascade. You must be crazy. Buckle up buddy boy, we're in for the big haul. I'll see you at the ship."));
			Map m = new House(arts, mobs);
			m.setPos(new Point(-6,-13));
			return m;
		}
		return null;
	}
	
	public String getMessage() {
		if(stoneId==1) {
			message = "Grandfather                                                 Space to select. Shift to Exit.";
		}else if(stoneId==2) {
			message = "Father                                                         Space to select. Shift to Exit.";
		}else if(stoneId==3) {
			message = "Son                                                                  Space to select. Shift to Exit.";
		}
		return message;
	}
	public byte getId() {
		return od;
	}
	public byte getSId() {
		return stoneId;
	}
	
}
