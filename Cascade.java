package com.first;

import java.awt.Point;
import java.util.ArrayList;

public class Cascade extends Map {

	
	
	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	private boolean openDoor = true;
		
	public Cascade() {
		super();
		for(int x=0; x<15; x++) {
			for(int y=-10; y<50; y++) {
				g.add(new Article((byte) 8, new Point(x*32, y*32)));
			}
		}
		for(int x=15; x<20; x++) {
			for(int y=-10; y<50; y++) {
				g.add(new Article((byte) 21, new Point(x*32, y*32)));
			}
		}
		for(int x=20; x<26; x++) {
			for(int y=-10; y<50; y++) {
				g.add(new Article((byte) 2, new Point(x*32, y*32)));
			}
		}
		for(int x=26; x<70; x++) {
			for(int y=0; y<40; y++) {
				g.add(new Article((byte) 28, new Point(x*32, y*32)));
			}
		}
		for(int x=26; x<70; x++) {
			for(int y=-8; y<5; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=20; x<26; x++) {
			for(int y=0; y<21; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=26; x<30; x++) {
			for(int y=20; y<23; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=26; x<70; x++) {
			for(int y=40; y<50; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=45; x<60; x++) {
			for(int y=-10; y<50; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		
		for(int x=32; x<60; x++) {
			for(int y=20; y<23; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		if(openDoor) {
			g.add(new Article((byte) 38, new Point(30*32, 21*32)));//door
		}
		
		for(int x=15; x<20; x++) {
			g.add(new Article((byte) 25, new Point(x*32, 20*32)));
		}
		for(int x=18; x<24; x++) {
			g.add(new Article((byte) 25, new Point(x*32, 21*32)));
		}
		for(int x=20; x<26; x++) {
			g.add(new Article((byte) 25, new Point(x*32, 22*32)));
		}
		for(int x=15; x<20; x++) {
			g.add(new Article((byte) 25, new Point(x*32, 39*32)));
		}
		for(int x=18; x<24; x++) {
			g.add(new Article((byte) 25, new Point(x*32, 40*32)));
		}
		for(int x=20; x<26; x++) {
			g.add(new Article((byte) 25, new Point(x*32, 41*32)));
		}
		g.add(new Article((byte) 30, new Point(5*32, 22*32)));
		g.add(new Article((byte) 9, new Point(4*32, 22*32)));
		g.add(new Article((byte) 9, new Point(8*32, 24*32)));
		g.add(new Article((byte) 9, new Point(7*32, 26*32)));
		g.add(new Article((byte) 29, new Point(35*32, 27*32), (byte)1));
		g.add(new Article((byte) 29, new Point(37*32, 27*32), (byte)2));
		g.add(new Article((byte) 29, new Point(39*32, 27*32), (byte)3));
		g.add(new Article((byte) 15, new Point(37*32, 31*32), "Brothers and sisters have I none. But this man's father is my fathers son. Who am i?"));
		
		mobs.add(new Mob((byte) 14, new Point(32*32, 12*32), "Who dares disturb the crypt of Falgoric's Rod."));
		
		mobs.add(new Mob((byte)0, new Point(40*32,38*32)));
		mobs.add(new Mob((byte)0, new Point(22*32,30*32)));
		mobs.add(new Mob((byte)0, new Point(30*32,23*32)));
		mobs.add(new Mob((byte)0, new Point(15*32,28*32)));
		mobs.add(new Mob((byte)0, new Point(10*32,22*32)));
	}
	
	public ArrayList<Article> getGraph() {
		return g;
	}
	public ArrayList<Mob> getMob() {
		return mobs;
	}
	private boolean activate2 = false;
	public void activate(Article a) {
		if(activate2) {
			g.add(new Article((byte) 44, new Point(10*32,10*32)));
		}else {
			if(g.get(5454).getName()=="door") {
				if(a.getSId()==1) {
					mobs.add(new Mob((byte)0, new Point(12*32,16*32)));
				}else if(a.getSId()==2) {
					g.remove(5454);
					activate2 = true;
				}else if(a.getSId()==3) {
					mobs.add(new Mob((byte)0, new Point(15*32,18*32)));
				}
			}
		}
	}
}
