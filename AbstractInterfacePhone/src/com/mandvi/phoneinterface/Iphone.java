package com.mandvi.phoneinterface;

public class Iphone extends Phone implements Ringable {

	public Iphone(String versionNumber, int batteryPercentage, int memory, String carrier, String ringtone) {
		super(versionNumber, batteryPercentage, memory, carrier, ringtone);
		
	}

	@Override
	public void displayInfo() {
		System.out.println(
			String.format("siri has: \n version : %s \n battery : %d \n memory : %d \n carrier : %s \n ringtone: %s ", this.getVersionNumber(),this.getBatteryPercentage(), this.getMemory(), this.getCarrier(), this.getRingtone())
			
	);
		
	}

	@Override
	public void ring() {
		System.out.println("Buzz Buzz");
		
	}

	@Override
	public void unlock() {
		System.out.println("click");
		
	}

}
