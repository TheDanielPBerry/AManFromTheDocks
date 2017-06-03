package com.first;

import java.awt.Point;
import java.util.ArrayList;

public class Dome extends Map {

	
	
	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
		
	public Dome() {
		super();
		for(int x=-30; x<15; x++) {
			for(int y=-15; y<0; y++) {
				g.add(new Article((byte) 10, new Point(x*32, y*32)));
			}
		}
		for(int x=-30; x<15; x++) {
			for(int y=15; y<30; y++) {
				g.add(new Article((byte) 10, new Point(x*32, y*32)));
			}
		}
		for(int x=15; x<30; x++) {
			for(int y=-15; y<30; y++) {
				g.add(new Article((byte) 10, new Point(x*32, y*32)));
			}
		}
		for(int x=-30; x<15; x++) {
			for(int y=0; y<15; y++) {
				g.add(new Article((byte) 3, new Point(x*32, y*32)));
			}
		}
		for(int x=-60; x<-30; x++) {
			for(int y=-10; y<20; y++) {
				g.add(new Article((byte) 47, new Point(x*32, y*32)));
			}
		}
		for(int x=-75; x<-30; x++) {
			for(int y=-25; y<-10; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=-75; x<-30; x++) {
			for(int y=25; y<40; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=-75; x<-30; x++) {
			for(int y=25; y<40; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=-75; x<-30; x++) {
			for(int y=20; y<35; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		for(int x=-75; x<-60; x++) {
			for(int y=-10; y<20; y++) {
				g.add(new Article((byte) 12, new Point(x*32, y*32)));
			}
		}
		mobs.add(new Mob((byte) 5, new Point(-40*32,0*32), "Ian: You never should have came. Now I will destroy you along with the rest of the reality."));
		mobs.add(new Mob((byte) 7, new Point(10*32,5*32), "Edward: I'm going to hang back. You go ahead, Declin."));
		
		
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
