package com.mandvi.phoneinterface;

public class Android extends Phone {

	public Android(String versionNumber, int batteryPercentage, int memory, String carrier, String ringtone) {
		super(versionNumber, batteryPercentage, memory, carrier, ringtone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayInfo() {
		System.out.println(
				String.format("Bixby has: \n version : %s \n battery : %d \n memory : %d \n carrier : %s \n ringtone: %s ", this.getVersionNumber(),this.getBatteryPercentage(), this.getMemory(), this.getCarrier(), this.getRingtone())
				
		);

	}

}
