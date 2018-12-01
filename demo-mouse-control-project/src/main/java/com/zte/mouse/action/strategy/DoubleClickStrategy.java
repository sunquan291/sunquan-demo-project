package com.zte.mouse.action.strategy;

import java.awt.event.InputEvent;

public class DoubleClickStrategy extends ClickStrategy{
	private int interval=100;//100ms
	
	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public void action() {
		robot.delay(this.getWaitTime());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(this.getInterval());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
}
