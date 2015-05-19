package lesson2.phone;

public class IPhone extends Phone {
	
	public IPhone() {
		System.out.println("IPhone constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	@Override
    protected final void makeCall(String number) {
		System.out.println("IPhone class is calling " + number);
	}
	
	@Override
	protected void sendOutSMS(String number, String message) {
		System.out.println("IPhone class is sending sms " + message + " to " + number);	
	}
}
