package com.first;

import java.awt.Point;
import java.util.ArrayList;

public class Teremona extends Map {

	

	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
		
	public Teremona() {
		super();
		for(int x=0; x<100; x++) {
			for(int y=0; y<60; y++) {
				g.add(new Article((byte) 0, new Point(x*32, y*32)));
			}
		}
		for(int x=0; x<100; x++) {
			for(int y=0; y<13; y+=2) {
				g.add(new Article((byte) 4, new Point(x*32, y*32)));
			}
		}
		for(int x=73; x<100; x++) {
			for(int y=14; y<34; y+=2) {
				g.add(new Article((byte) 4, new Point(x*32, y*32)));
			}
		}
		for(int x=13; x<25; x++) {
			for(int y=20; y<24; y++) {
				if(x!=16 || y!=23) {
					if(x!=20 || y!=23) {
						if(x!=21 || y!=23) {
							if(x!=17 || y!=23) {
								g.add(new Article((byte) 12, new Point(x*32, y*32)));
							}
						}
					}
				}
			}
		}
		for(int x=8; x<28; x++) {
			for(int y=26; y<30; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		
		for(int x=11; x<53; x++) {
			for(int y=24; y<26; y++) {
				g.add(new Article((byte) 11, new Point(x*32, y*32)));
			}
		}
		for(int x=8; x<13; x++) {
			for(int y=21; y<30; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		g.add(new Article((byte) 19, new Point(20*32, 22*32)));
		g.add(new Article((byte) 19, new Point(16*32, 22*32)));
		g.add(new Article((byte) 20, new Point(15*32, 12*32)));
		g.add(new Article((byte) 17, new Point(72*32, 34*32)));
		g.add(new Article((byte) 18, new Point(72*32, 38*32)));
		g.add(new Article((byte) 18, new Point(72*32, 39*32)));
		for(int x=25; x<50; x++) {
			g.add(new Article((byte) 18, new Point(x*32, 23*32)));
		}
		for(int x=28; x<50; x++) {
			g.add(new Article((byte) 18, new Point(x*32, 26*32)));
		}
		for(int x=25; x<49; x+=4) {
			g.add(new Article((byte) 17, new Point(x*32, 19*32)));
			g.add(new Article((byte) 17, new Point(x*32, 15*32)));
		}
		for(int x=28; x<49; x+=4) {
			g.add(new Article((byte) 17, new Point(x*32, 27*32)));
			g.add(new Article((byte) 17, new Point(x*32, 31*32)));
		}
		g.add(new Article((byte) 22, new Point(61*32, 20*32)));
		g.add(new Article((byte) 13, new Point(66*32, 22*32)));
		g.add(new Article((byte) 37, new Point(56*32, 17*32)));
		g.add(new Article((byte) 17, new Point(52*32, 18*32)));
		g.add(new Article((byte) 17, new Point(61*32, 25*32)));
		for(int x=40; x<100; x++) {
			for(int y=40; y<45; y++) {
				g.add(new Article((byte) 21, new Point(x*32, y*32)));
			}
		}
		for(int x=10; x<40; x++) {
			for(int y=40; y<70; y++) {
				g.add(new Article((byte) 8, new Point(x*32, y*32)));
			}
		}
		for(int x=39; x<100; x++) {
			for(int y=45; y<70; y++) {
				if(!((x==65 && ((y<53))) || (x==66 && ((y<53))) || (x==50 && ((y<53))) || (x==51 && ((y<53))))) {
					g.add(new Article((byte) 8, new Point(x*32, y*32)));
				}
			}
		}
		g.add(new Article((byte) 21, new Point(39*32, 40*32)));
		g.add(new Article((byte) 21, new Point(39*32, 41*32)));
		g.add(new Article((byte) 21, new Point(39*32, 42*32)));
		g.add(new Article((byte) 18, new Point(49*32, 35*32)));
		g.add(new Article((byte) 18, new Point(48*32, 14*32)));
		
		for(int x=24; x<50; x++) {
			for(int y=36; y<39; y+=2) {
				g.add(new Article((byte) 4, new Point(x*32, y*32)));
			}
		}
		for(int x=57; x<59; x++) {
			for(int y=30; y<43; y++) {
				g.add(new Article((byte) 11, new Point(x*32, y*32)));
			}
		}

		for(int x=65; x<67; x++) {
			for(int y=44; y<53; y++) {
				g.add(new Article((byte) 6, new Point(x*32, y*32)));
			}
		}
		for(int x=50; x<52; x++) {
			for(int y=44; y<53; y++) {
				g.add(new Article((byte) 6, new Point(x*32, y*32)));
			}
		}
		g.add(new Article((byte) 44, new Point(66*32, 50*32)));
		g.add(new Article((byte) 7, new Point(65*32, 53*32)));
		g.add(new Article((byte) 7, new Point(66*32, 53*32)));
		g.add(new Article((byte) 7, new Point(50*32, 53*32)));
		g.add(new Article((byte) 7, new Point(51*32, 53*32)));
		g.add(new Article((byte) 24, new Point(67*32, 48*32)));
		g.add(new Article((byte) 9, new Point(60*32, 58*32)));
		g.add(new Article((byte) 9, new Point(45*32, 55*32)));
		g.add(new Article((byte) 9, new Point(55*32, 63*32)));
		g.add(new Article((byte) 18, new Point(72*32, 40*32)));
		g.add(new Article((byte) 25, new Point(73*32, 40*32)));
		g.add(new Article((byte) 25, new Point(74*32, 41*32)));
		g.add(new Article((byte) 25, new Point(74*32, 42*32)));
		g.add(new Article((byte) 25, new Point(74*32, 43*32)));
		g.add(new Article((byte) 25, new Point(74*32, 44*32)));
		g.add(new Article((byte) 25, new Point(75*32, 43*32)));
		g.add(new Article((byte) 25, new Point(75*32, 44*32)));
		
		

		mobs.add(new Mob((byte) 1, new Point(60*32, 30*32), "Old Lady: I remember back in my day \"Lost\" made sense."));
		mobs.add(new Mob((byte) 8, new Point(49*32, 40*32), "Sailor: There ain't nothin quite like the feel of the sea on yur face."));
		mobs.add(new Mob((byte) 9, new Point(35*32, 29*32), ""));
		
	}
	
	public ArrayList<Article> getGraph() {
		return g;
	}
	
	public ArrayList<Mob> getMob() {
		return mobs;
	}
	
	public void activate(Article a) {
	}
	
}
