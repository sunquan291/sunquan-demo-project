package com.zte.mouse.task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import com.zte.mouse.action.strategy.MouseAction;

public class MouseTimerTask extends TimerTask{

	private List<MouseAction> mouseStrategies=new ArrayList<MouseAction>();
	
	@Override
	public void run() {
		for(MouseAction mouseStrategy:mouseStrategies){
			mouseStrategy.action();
		}
	}
	
	public void addStrategy(MouseAction mouseAction){
		synchronized (mouseAction) {
			mouseStrategies.add(mouseAction);
		}
	}

}
