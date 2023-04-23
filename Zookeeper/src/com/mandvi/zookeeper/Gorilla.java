package com.mandvi.zookeeper;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla has thrown something");
		int newLevel = this.getEnergyLevel() - 5;
		this.setEnergyLevel(newLevel);
	}
	public void eatBananas() {
		System.out.println("Gorilla satisfied");
		int newLevel = this.getEnergyLevel() + 10;
		this.setEnergyLevel(newLevel);
	}
	public void climb() {
		System.out.println("Gorilla has climbed the tree");
		int newLevel = this.getEnergyLevel() - 10;
		this.setEnergyLevel(newLevel);
	}
}
