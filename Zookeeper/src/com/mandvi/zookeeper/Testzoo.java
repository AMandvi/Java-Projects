package com.mandvi.zookeeper;

public class Testzoo {

	public static void main(String[] args) {
		Gorilla g1 = new Gorilla();
		g1.throwSomething();
		g1.throwSomething();
		g1.throwSomething();
		g1.eatBananas();
		g1.eatBananas();
		g1.climb();
		g1.displayEnergy();
		
		
		Bat b1 = new Bat();
		b1.attackTown();
		b1.attackTown();
		b1.attackTown();
		b1.eatHumans();
		b1.eatHumans();
		b1.fly();
		b1.fly();
		b1.displayEnergy();

	}

}
