package com.weather;

public class Weather {
	private int hour;
	private double temp;
	private String wfKor;
	private int reh;
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public String getWfKor() {
		return wfKor;
	}
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	public int getReh() {
		return reh;
	}
	public void setReh(int reh) {
		this.reh = reh;
	}
	
	public Weather() {}
	
	public Weather(int hour, double temp, String wfKor, int reh) {
		super();
		this.hour = hour;
		this.temp = temp;
		this.wfKor = wfKor;
		this.reh = reh;
	}
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfKor=" + wfKor + ", reh=" + reh + "]";
	}
	
	
}
