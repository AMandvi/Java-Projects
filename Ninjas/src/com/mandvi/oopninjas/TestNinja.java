package com.mandvi.oopninjas;

public class TestNinja {

	public static void main(String[] args) {
//		System.out.println("hi ninja");
		Ninja ninja1 = new Ninja("Joe", "Fists", "Hard Knox", 70,150,10);
		Ninja ninja2 = new Ninja("Peter", "katana", "School", 50,130,40);
		
		ninja1.attack(ninja2);
		
		Sensei oogway = new Sensei("oogway", "staff", "panda school", 9002, 1000, 100, "this is why we call it present");
		oogway.speakWisdom();
		
		ninja1.attack(oogway);
		


	}

}
