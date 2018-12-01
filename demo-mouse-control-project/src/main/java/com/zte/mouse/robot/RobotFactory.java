package com.zte.mouse.robot;

import java.awt.AWTException;
import java.awt.Robot;

public class RobotFactory {
	private static Robot robot;
	public static Robot getInstance(){
		if(robot==null){
			try {
				robot=new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		return robot;
	}
}
