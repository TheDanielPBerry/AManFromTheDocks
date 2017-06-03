package com.first;

import java.awt.Point;
import java.util.ArrayList;

public class Baduz extends Map {
	
	

	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	
	public Baduz() {
		super();
		for(int x=-10; x<70; x++) {
			for(int y=-10; y<10; y++) {
				if(!(x==40 && y>2) && !(x==41 && y>2)) {
					g.add(new Article((byte) 8, new Point(x*32, y*32)));
				}
			}
		}
		for(int x=-10; x<10; x++) {
			for(int y=-10; y<70; y++) {
				g.add(new Article((byte) 8, new Point(x*32, y*32)));
			}
		}
		for(int x=-10; x<100; x++) {
			for(int y=70; y<100; y++) {
				g.add(new Article((byte) 8, new Point(x*32, y*32)));
			}
		}
		for(int x=70; x<100; x++) {
			for(int y=-10; y<100; y++) {
				g.add(new Article((byte) 8, new Point(x*32, y*32)));
			}
		}
		for(int x=10; x<70; x++) {
			for(int y=10; y<70; y++) {
				g.add(new Article((byte) 21, new Point(x*32, y*32)));
			}
		}
		for(int x=41; x<43; x++) {
			for(int y=20; y<40; y++) {
				g.add(new Article((byte) 14, new Point(x*32, y*32)));
			}
		}
		for(int x=40; x<42; x++) {
			for(int y=2; y<12; y++) {
				g.add(new Article((byte) 6, new Point(x*32, y*32)));
			}
		}
		g.add(new Article((byte) 24, new Point(42*32, 0*32)));
		g.add(new Article((byte) 26, new Point(34*32, 24*32)));
		g.add(new Article((byte) 26, new Point(44*32, 33*32)));
		g.add(new Article((byte) 27, new Point(34*32, 29*32)));
		g.add(new Article((byte) 8, new Point(9*32, 10*32)));
		g.add(new Article((byte) 8, new Point(10*32, 10*32)));
		g.add(new Article((byte) 8, new Point(11*32, 10*32)));
		g.add(new Article((byte) 8, new Point(9*32, 11*32)));
		g.add(new Article((byte) 8, new Point(9*32, 12*32)));
		g.add(new Article((byte) 8, new Point(9*32, 13*32)));
		g.add(new Article((byte) 8, new Point(69*32, 10*32)));
		g.add(new Article((byte) 8, new Point(68*32, 10*32)));
		g.add(new Article((byte) 8, new Point(67*32, 10*32)));
		g.add(new Article((byte) 8, new Point(66*32, 10*32)));
		g.add(new Article((byte) 8, new Point(65*32, 10*32)));
		g.add(new Article((byte) 8, new Point(64*32, 10*32)));
		g.add(new Article((byte) 8, new Point(68*32, 10*32)));
		g.add(new Article((byte) 8, new Point(69*32, 11*32)));
		g.add(new Article((byte) 8, new Point(69*32, 12*32)));
		g.add(new Article((byte) 8, new Point(69*32, 13*32)));
		g.add(new Article((byte) 8, new Point(69*32, 14*32)));
		g.add(new Article((byte) 8, new Point(69*32, 69*32)));
		g.add(new Article((byte) 8, new Point(68*32, 69*32)));
		g.add(new Article((byte) 8, new Point(67*32, 69*32)));
		g.add(new Article((byte) 8, new Point(66*32, 69*32)));
		g.add(new Article((byte) 8, new Point(65*32, 69*32)));
		g.add(new Article((byte) 8, new Point(69*32, 68*32)));
		g.add(new Article((byte) 8, new Point(69*32, 67*32)));
		g.add(new Article((byte) 8, new Point(69*32, 66*32)));
		g.add(new Article((byte) 8, new Point(69*32, 65*32)));
		g.add(new Article((byte) 8, new Point(69*32, 64*32)));
		g.add(new Article((byte) 8, new Point(10*32, 69*32)));
		g.add(new Article((byte) 8, new Point(11*32, 69*32)));
		g.add(new Article((byte) 8, new Point(12*32, 69*32)));
		g.add(new Article((byte) 8, new Point(13*32, 69*32)));
		g.add(new Article((byte) 8, new Point(10*32, 69*32)));
		g.add(new Article((byte) 8, new Point(10*32, 68*32)));
		g.add(new Article((byte) 8, new Point(10*32, 67*32)));
		g.add(new Article((byte) 8, new Point(10*32, 66*32)));
		

		g.add(new Article((byte) 5, new Point(15*32, 60*32)));
		g.add(new Article((byte) 5, new Point(54*32, 30*32)));
		g.add(new Article((byte) 5, new Point(50*32, 20*32)));
		g.add(new Article((byte) 5, new Point(25*32, 50*32)));
		g.add(new Article((byte) 5, new Point(36*32, 40*32)));
		g.add(new Article((byte) 44, new Point(41*32, 4*32)));
		g.add(new Article((byte) 15, new Point(42*32, 14*32), "Welcome to Baduz. Now Please Go Away."));
		
		mobs.add(new Mob((byte) 11, new Point(40*32, 27*32), "Thug: What are you lookin at scumbag. Wanna get knifed?"));
		mobs.add(new Mob((byte) 10, new Point(43*32, 37*32), "Pirate: Oh, how I miss my lovely wife! The sea has separa-ted me from her for so long now."));
		
	}
	
	public ArrayList<Article> getGraph() {
		return g;
	}
	
	public ArrayList<Mob> getMob() {
		return mobs;
	}

	@Override
	public void activate(Article a) {
		// TODO Auto-generated method stub
		
	}
	
}
