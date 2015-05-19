package lesson2.phone;

public class PhoneExample {

	public static void main(String[] args) {
		// Phone p = new Phone();
		
		Nokia3310 nokia = new Nokia3310();
		System.out.println("Nokia3310 screent size: " + nokia.getScreenSize());
		nokia.call("123-45-67");
		nokia.call("123-45-62");
        nokia.call("123-45-61");
		nokia.sendSMS("567-78-89", "text message");
        System.out.println("Nokia number: " + nokia.getNumber());
        nokia.setNumber("123-45-67");
        System.out.println("Nokia number: " + nokia.getNumber());

		System.out.println("----------------------------------");
		
		IPhone iphone = new IPhone();
		System.out.println("IPhone screent size: " + iphone.getScreenSize());
		iphone.call("123-45-67");
		iphone.sendSMS("567-78-89", "text message");
		
		System.out.println("----------------------------------");
		
		IPhone5 iphone5 = new IPhone5();
		System.out.println("IPhone5 screent size: " + iphone5.getScreenSize());
		iphone5.call("123-45-67");
		iphone5.sendSMS("567-78-89", "text message");

        SamsungS4 samsung = new SamsungS4();
        System.out.println("Samsung screent size: " + samsung.getScreenSize());
        samsung.call("123-45-67");
        samsung.call("123-45-67");
        samsung.sendSMS("567-78-89", "text message");
        samsung.sendSMS("567-78-89", "text message");
        samsung.sendSMS("567-78-89", "text message");

        System.out.println("Nokia calls: " + nokia.getCallCounter());
        System.out.println("IPhone calls: " + iphone.getCallCounter());
        System.out.println("IPhone5 calls: " + iphone5.getCallCounter());
        System.out.println("Samsung calls: " + samsung.getCallCounter());

        System.out.println("Nokia sms: " + nokia.getSmsCounterCounter());
        System.out.println("IPhone sms: " + iphone.getSmsCounterCounter());
        System.out.println("IPhone5 sms: " + iphone5.getSmsCounterCounter());
        System.out.println("Samsung sms: " + samsung.getSmsCounterCounter());
    }
}
