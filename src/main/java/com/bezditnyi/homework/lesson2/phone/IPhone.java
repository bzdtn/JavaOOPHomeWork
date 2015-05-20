package com.bezditnyi.homework.lesson2.phone;

public class IPhone extends Phone {
	
	public IPhone() {
		System.out.println("IPhone constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	@Override
    public void call(String number) {
		super.call(number);
		System.out.println("IPhone class is calling " + number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
        super.sendSMS(number, message);
		System.out.println("IPhone class is sending sms " + message + " to " + number);	
	}
}
