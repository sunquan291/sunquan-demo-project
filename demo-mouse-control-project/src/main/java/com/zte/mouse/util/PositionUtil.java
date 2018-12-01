package com.zte.mouse.util;

import java.awt.MouseInfo;

import com.zte.mouse.action.strategy.Point;

public class PositionUtil {
	public static Point getCurPosition(){
		java.awt.Point p=MouseInfo.getPointerInfo().getLocation();
		Point point=new Point(p.x,p.y);
		return point;
	}
}
