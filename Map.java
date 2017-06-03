package com.first;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Map {
	
	
	
	
	public Map() {
		
	}
	
	

	public abstract ArrayList<Article> getGraph();
	public abstract ArrayList<Mob> getMob();
	
	public void setPos(Point p) {
		ArrayList<Article> articles = getGraph();
		for(int i=0; i<articles.size(); i++) {
			articles.get(i).setPos(new Point(p.x*32,(p.y*32)-16));
		}

		ArrayList<Mob> mobs = getMob();
		for(int i=0; i<mobs.size(); i++) {
			mobs.get(i).setPos(new Point(p.x*32,(p.y*32)-16));
		}
	}
	public abstract void activate(Article a);
}
