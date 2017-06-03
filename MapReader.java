package com.first;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class MapReader {
	
	public MapReader(Image map) {
		
	}
	
	public static int[] readMap(Image map) {
		int[] ids  = new int[map.getWidth(null)*map.getHeight(null)];
		int count = 0;
		for(int x=0; x<map.getWidth(null); x++) {
			for(int y=0; y<map.getHeight(null); y++) {
				ids[count] =  ((BufferedImage) map).getRGB(x,y);
				count++;
			}
		}
		return ids;
	}
	
}
