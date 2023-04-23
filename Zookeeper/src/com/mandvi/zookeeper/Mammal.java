package com.mandvi.zookeeper;

public class Mammal {
	private int energyLevel;
	
	//constructors
	public Mammal() {
		
		this.energyLevel = 0;
	}
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
	
	//getters and setters
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
