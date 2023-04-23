package com.mandvi.phoneinterface;

public abstract class Phone {
	private String versionNumber;
	private int batteryPercentage;
	private int memory;
	private String carrier;
	private String ringtone;
	
	//constructors
	public Phone(String versionNumber, int batteryPercentage, int memory, String carrier, String ringtone) {
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
		this.memory = memory;
		this.carrier = carrier;
		this.ringtone = ringtone;
	}
	
	public abstract void displayInfo();
	
	//Getters and setters------
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public int getBatteryPercentage() {
		return batteryPercentage;
	}
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getRingtone() {
		return ringtone;
	}
	public void setRingtone(String ringtone) {
		this.ringtone = ringtone;
	}
	
	

}
