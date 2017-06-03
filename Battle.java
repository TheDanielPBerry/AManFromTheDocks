package com.first;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Battle extends Map {

	private ArrayList<Article> g = new ArrayList<Article>();
	private ArrayList<Mob> mobs = new ArrayList<Mob>();
	
	public Battle() {
		
		for(int x=0; x<8; x++) {
			for(int y=0; y<4; y++) {
				g.add(new Article((byte) 47, new Point(x*32, y*32)));
			}
		}

		g.add(new Article((byte) 32, new Point(0*32, -1*32)));
		g.add(new Article((byte) 32, new Point(1*32, -1*32)));
		g.add(new Article((byte) 32, new Point(2*32, -1*32)));
		g.add(new Article((byte) 32, new Point(3*32, -1*32)));
		g.add(new Article((byte) 32, new Point(4*32, -1*32)));
		g.add(new Article((byte) 32, new Point(5*32, -1*32)));
		g.add(new Article((byte) 32, new Point(6*32, -1*32)));
		g.add(new Article((byte) 32, new Point(7*32, -1*32)));

		g.add(new Article((byte) 32, new Point(0*32, 4*32)));
		g.add(new Article((byte) 32, new Point(1*32, 4*32)));
		g.add(new Article((byte) 32, new Point(2*32, 4*32)));
		g.add(new Article((byte) 32, new Point(3*32, 4*32)));
		g.add(new Article((byte) 32, new Point(4*32, 4*32)));
		g.add(new Article((byte) 32, new Point(5*32, 4*32)));
		g.add(new Article((byte) 32, new Point(6*32, 4*32)));
		g.add(new Article((byte) 32, new Point(7*32, 4*32)));

		g.add(new Article((byte) 32, new Point(-1*32, 0*32)));
		g.add(new Article((byte) 32, new Point(-1*32, 1*32)));
		g.add(new Article((byte) 32, new Point(-1*32, 2*32)));
		g.add(new Article((byte) 32, new Point(-1*32, 3*32)));

		g.add(new Article((byte) 32, new Point(8*32, 0*32)));
		g.add(new Article((byte) 32, new Point(8*32, 1*32)));
		g.add(new Article((byte) 32, new Point(8*32, 2*32)));
		g.add(new Article((byte) 32, new Point(8*32, 3*32)));
		

		mobs.add(new Mob((byte)13, new Point(4*32, -7*32), ""));
	}
	
	
	
	public ArrayList<Article> getGraph() {
		return g;
	}
	
	public ArrayList<Mob> getMob() {
		return mobs;
	}
	
	private byte allow = 0;
	
	Random r = new Random();
	public void activate(Article a) {
		if(allow==0) {
			mobs.add(new Mob((byte)0, new Point(5*32, 10*32)));
			mobs.add(new Mob((byte)0, new Point(30*32, 10*32)));
			allow=1;
		}else if(allow==1) {
			mobs.add(new Mob((byte)14, new Point(mobs.get(0).getX(), mobs.get(0).getY()+32), new Point(400, 300)));
			allow=0;
		}
	}
}
