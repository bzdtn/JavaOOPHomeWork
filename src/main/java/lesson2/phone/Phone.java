package lesson2.phone;

import com.sun.istack.internal.Nullable;

import java.util.LinkedList;
import java.util.List;

public abstract class Phone {

    private static LinkedList<Phone> list;
    static {
        Phone.list = new LinkedList<Phone>();
    }

	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;

	private int smsCounter = 0;
	private int callCounter = 0;

    protected String phoneNumber;
	
	public Phone() {
//		System.out.println("Phone constructor");
//        Phone.list.add(this);
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

    public void call1(String number) {
        System.out.println("Phone class is calling " + number);
        Phone phone = Phone.find(number);
        if (phone == null){
            System.out.println("Wrong phone number");
        } else {
            phone.answer();
        }
    }
	public abstract void sendSMS(String number, String message);

	public int getSmsCounter() {
		return smsCounter;
	}

	public int getCallCounter() {
		return callCounter;
	}

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public static Phone find(String number){
        for (Phone p: Phone.list){
            if (p.getPhoneNumber().equalsIgnoreCase(number)){
                return p;
            }
        }
        return null;
    }

    public void answer(){
        System.out.println("Pronto!!!");
    }

	public final void callC(String number){
		this.callCounter++;
		this.call(number);
	}

	public final void sendSMSC(String number, String message){
		this.smsCounter++;
		this.sendSMS(number, message);
	}
}
