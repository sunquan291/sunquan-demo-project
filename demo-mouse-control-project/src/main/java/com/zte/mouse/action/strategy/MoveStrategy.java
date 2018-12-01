package com.zte.mouse.action.strategy;

import java.awt.Robot;

import com.zte.mouse.robot.RobotFactory;

public class MoveStrategy implements MouseAction{
	private Point startPosition;
	private Point endPosition;
	private int waitTime;
	private Robot robot;
	private boolean needBack;
	public MoveStrategy(Robot robot){
		this.robot=robot;
	}
	public MoveStrategy(){
		robot=RobotFactory.getInstance();
	}
	public Point getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(Point startPosition) {
		this.startPosition = startPosition;
	}
	public Point getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(Point endPosition) {
		this.endPosition = endPosition;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public boolean isNeedBack() {
		return needBack;
	}
	public void setNeedBack(boolean needBack) {
		this.needBack = needBack;
	}
	@Override
	public void action() {
		robot.delay(this.waitTime);
		robot.mouseMove(endPosition.getX(),endPosition.getY());
		if(needBack){
			robot.mouseMove(startPosition.getX(), startPosition.getY());
		}
	}
	public void setEndPosition(int x, int y) {
		this.setEndPosition(new Point(x,y));
	}
	
}
