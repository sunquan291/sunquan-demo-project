package com.zte.mouse.data;

public class PositionData {
	private int time=0;
	private int txt1_x=0;
	private int txt1_y=0;
	//point 2
	private int txt2_x=0;
	private int txt2_y=0;
	//click point
	private int txtc1_x=0;
	private int txtc1_y=0;
	
	
	public PositionData(int time, int txt1_x, int txt1_y, int txt2_x,
			int txt2_y, int txtc1_x, int txtc1_y) {
		super();
		this.time = time;
		this.txt1_x = txt1_x;
		this.txt1_y = txt1_y;
		this.txt2_x = txt2_x;
		this.txt2_y = txt2_y;
		this.txtc1_x = txtc1_x;
		this.txtc1_y = txtc1_y;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTxt1_x() {
		return txt1_x;
	}
	public void setTxt1_x(int txt1_x) {
		this.txt1_x = txt1_x;
	}
	public int getTxt1_y() {
		return txt1_y;
	}
	public void setTxt1_y(int txt1_y) {
		this.txt1_y = txt1_y;
	}
	public int getTxt2_x() {
		return txt2_x;
	}
	public void setTxt2_x(int txt2_x) {
		this.txt2_x = txt2_x;
	}
	public int getTxt2_y() {
		return txt2_y;
	}
	public void setTxt2_y(int txt2_y) {
		this.txt2_y = txt2_y;
	}
	public int getTxtc1_x() {
		return txtc1_x;
	}
	public void setTxtc1_x(int txtc1_x) {
		this.txtc1_x = txtc1_x;
	}
	public int getTxtc1_y() {
		return txtc1_y;
	}
	public void setTxtc1_y(int txtc1_y) {
		this.txtc1_y = txtc1_y;
	}
	
}
