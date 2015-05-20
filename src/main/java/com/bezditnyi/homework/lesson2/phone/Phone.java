package com.bezditnyi.homework.lesson2.phone;

import java.util.LinkedList;

public abstract class Phone {

    private static LinkedList<Phone> list;
    static {
        list = new LinkedList<Phone>();
    }

	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;

    private String number;

    private int callCounter = 0;
    private int smsCounter = 0;

    public Phone() {
        System.out.println("Phone constructor");
        list.add(this);
    }
	
	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}

    public final int getCallCounter(){
        return this.callCounter;
    }

    public final int getSmsCounterCounter(){
        return this.smsCounter;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void call(String number) {
        this.callCounter++;
        System.out.println("Phone class is calling " + number);
        Phone phone = Phone.find(number);
        if (phone == null){
            System.out.println("Wrong phone number");
        } else {
            phone.answer();
        }
	}

	public void sendSMS(String number, String message){
        this.smsCounter++;
    }

    public void answer(){
        System.out.println("Pronto!!!");
    }

    public static Phone find(String number){
        for (Phone p: Phone.list){
            if (number.equalsIgnoreCase(p.getNumber())){
                return p;
            }
        }
        return null;
    }
}


/*
package com.bezditnyi.homework.lesson2.phone;

public abstract class Phone {

	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;

    public Phone() {
        System.out.println("Phone constructor");
    }

	public boolean isTouch() {
		return touch;
	}

	public boolean isHasWifi() {
		return hasWifi;
	}

	public int getScreenSize() {
		return screenSize;
	}

    public void call(String number) {
		System.out.println("Phone class is calling " + number);
	}

	public abstract void sendSMS(String number, String message);
}


package com.bezditnyi.homework.lesson2.phone;

import java.util.LinkedList;

public abstract class Phone {

    private static LinkedList<Phone> list;
    static {
        list = new LinkedList<Phone>();
    }

	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;

    private String number;

    private int callCounter = 0;
    private int smsCounter = 0;

    public Phone() {
        System.out.println("Phone constructor");
        list.add(this);
    }

	public boolean isTouch() {
		return touch;
	}

	public boolean isHasWifi() {
		return hasWifi;
	}

	public int getScreenSize() {
		return screenSize;
	}

    public final int getCallCounter(){
        return this.callCounter;
    }

    public final int getSmsCounterCounter(){
        return this.smsCounter;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public final void call(String number) {
        this.callCounter++;
        this.makeCall(number);
        Phone phone = Phone.find(number);
        if (phone == null){
            System.out.println("Wrong phone number");
        } else {
            phone.answer();
        }
	}

	protected void makeCall(String number){
        System.out.println("Phone class is calling " + number);
    }

	public final void sendSMS(String number, String message){
        this.smsCounter++;
        this.sendOutSMS(number, message);
    }

    protected abstract void sendOutSMS(String number, String message);

    public void answer(){
        System.out.println("Pronto!!!");
    }

    public static Phone find(String number){
        for (Phone p: Phone.list){
            if (number.equalsIgnoreCase(p.getNumber())){
                return p;
            }
        }
        return null;
    }
}

 */