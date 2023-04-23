package com.mandvi.oopninjas;

public class Ninja {
	private String name;
	private String weapon;
	private String school;
	private int powerLevel;
	private int health;
	private int stamina;
	
//	public Ninja() {
//		this.name = "anonymous";
//		this.weapon = "punches";
//		this.health =100;
//		
//	}

	public Ninja(String name, String weapon, String school, int powerLevel, int health, int stamina) {
		this.name = name;
		this.weapon = weapon ;
		this.school = school;
		this.powerLevel = powerLevel;
		this.health = health;
		this.stamina = stamina;
	}
	
	//METHODS
	public void attack (Ninja target) {
		System.out.println(this.getName() + " attacks " + target.getName());
		target.setHealth(target.getHealth() - this.powerLevel);
		System.out.println(target.getName() + " now has " + target.getHealth() + " hp left");
	}

	// GETTERs AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

}
