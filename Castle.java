package com.first;

import java.awt.Point;
import java.util.ArrayList;

public class Castle extends Map {

	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	
	public Castle() {
		g = new ArrayList<Article>();
		mobs = new ArrayList<Mob>();
		for(int x=0;x<30; x++) {
			for(int y=0;y<10; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=0;x<10; x++) {
			for(int y=0;y<50; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=0;x<30; x++) {
			for(int y=40;y<41; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=25;x<26; x++) {
			for(int y=0;y<42; y++) {
				g.add(new Article((byte)32, new Point(x*32, y*32)));
			}
		}
		for(int x=10;x<25; x++) {
			for(int y=10;y<40; y++) {
				g.add(new Article((byte)33, new Point(x*32, y*32)));
			}
		}
		g.add(new Article((byte)39, new Point(13*32, 12*32)));
		g.add(new Article((byte)34, new Point(15*32, 38*32)));
		mobs.add(new Mob((byte)4, new Point(14*32, 14*32), "King: The professor has informed me of your troubles here please take a sword of mine and use the ship \"HMS Latifah\" to track him down to the Noble Devil's Dome."));
		mobs.add(new Mob((byte)3, new Point(21*32, 13*32), "Guard: Stay out of tall grass! Poke-men can be found there."));
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
