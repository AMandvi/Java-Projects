package com.mandvi.zookeeper;

public class Bat extends Mammal {

	//Constructor
	public Bat() {
		super(300);	
	}
	
	//methods
	public void fly() {
		System.out.println("Sound of a bat");
		int newLevel = this.getEnergyLevel() - 50;
		this.setEnergyLevel(newLevel);
	}
	public void eatHumans() {
		System.out.println("So-well never mind");
		int newLevel = this.getEnergyLevel() + 25;
		this.setEnergyLevel(newLevel);
	}
	public void attackTown() {
		System.out.println("sound of a town on fire");
		int newLevel = this.getEnergyLevel() - 100;
		this.setEnergyLevel(newLevel);
	}
	

}
