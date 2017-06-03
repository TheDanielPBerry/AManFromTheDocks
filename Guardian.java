package com.first;

import java.awt.Point;

public class Guardian extends Mob {

	private static Point pos = new Point(30, 20);
	
	public Guardian() {
		super((byte)0, pos);
	}
	
}
