package com.zte.mouse.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Launcher {
	private long cycleTime = 5000;// 1s
	private long delayTime = 0;
	private Timer timer ;
	private List<TimerTask> timerTasks=new ArrayList<TimerTask>();

	public void start() {
		for (final TimerTask mouseTimerTask : timerTasks) {
			timer=new Timer();
			Thread procedure = new Thread(new Runnable() {
				@Override
				public void run() {
					timer.scheduleAtFixedRate(mouseTimerTask, delayTime,
							cycleTime);
				}
			});
			procedure.start();
		}
	}
	public void pause(){
	}

	public void stop(){
		for (final TimerTask mouseTimerTask : timerTasks) {
			mouseTimerTask.cancel();
		}
	}
	
	public long getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}

	public long getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(long cycleTime) {
		this.cycleTime = cycleTime;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public List<TimerTask> getTimerTasks() {
		return timerTasks;
	}

	public void setTimerTasks(List<TimerTask> timerTasks) {
		this.timerTasks = timerTasks;
	}
	public void addTimerTask(TimerTask timerTask){
		timerTasks.add(timerTask);
	}

}
