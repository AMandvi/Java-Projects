package com.mandvi.oopninjas;

import java.util.ArrayList;

public class Sensei extends Ninja implements Knowledgeable{
	
	private ArrayList<String>skills;
	private String wisdom;

	public Sensei(String name, 
				String weapon, 
				String school, 
				int powerLevel, 
				int health, 
				int stamina,
				String wisdom) {
		super(name, 
				weapon, 
				school, 
				powerLevel, 
				health, 
				stamina);
		this.skills = new ArrayList<String>();
		this.wisdom = wisdom;
	}
	
	//methods----
	
	public void speakWisdom() {
		System.out.println(this.getName() + " says " + this.getWisdom());
		
	}
	
	//CAN overwrite method-----
	
//	public void attack (Ninja t) {
//		
//	}
	//------

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}

	public String getWisdom() {
		return wisdom;
	}

	public void setWisdom(String wisdom) {
		this.wisdom = wisdom;
	}

	@Override
	public void drinkSake() {
		System.out.println("yum!!!");
		
	}
	

}
