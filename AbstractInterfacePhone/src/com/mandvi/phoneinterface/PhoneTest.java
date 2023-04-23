package com.mandvi.phoneinterface;

public class PhoneTest {

	public static void main(String[] args) {
		
//		Phone phone1 = new Phone("iOS16",100,4,"AT&T", "ringringring");
//		phone1.displayInfo();
		
		Iphone iphone1 = new Iphone ("ios16",100, 4, "AT&T", "RING RING RING" );
		iphone1.displayInfo();
		
		Android galaxys = new Android ("Android13", 110, 16, "Space Carrier", "BOOM BOOM");
		galaxys.displayInfo();

	}

}
