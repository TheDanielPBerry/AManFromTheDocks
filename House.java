package com.first;

import java.awt.Point;
import java.util.ArrayList;

public class House extends Map {

	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	
	public House() {
		for(int x=0;x<30; x++) {
			for(int y=0;y<10; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=0;x<10; x++) {
			for(int y=0;y<30; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=10;x<25; x++) {
			for(int y=10;y<25; y++) {
				g.add(new Article((byte)35, new Point(x*32, y*32)));
			}
		}
		for(int x=25;x<30; x++) {
			for(int y=10;y<25; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=0;x<30; x++) {
			for(int y=25;y<30; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
	}
	

	public House(ArrayList<Article> arts) {
		this();
		g.addAll(arts);
	}	
	public House(ArrayList<Article> arts,ArrayList<Mob> m) {
		this();
		g.addAll(arts);
		mobs.addAll(m);
	}
	
	public ArrayList<Article> getGraph() {
		return g;
	}
	
	public ArrayList<Mob> getMob() {
		return mobs;
	}


	@Override
	public void activate(Article a) {
		mobs.remove(0);
		mobs.remove(1);
	}
}
