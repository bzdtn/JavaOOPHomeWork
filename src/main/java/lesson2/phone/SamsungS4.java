package lesson2.phone;

public class SamsungS4 extends Phone {

    public SamsungS4(){
        System.out.println("SamsungS4 constructor");
        this.touch = false;
        this.hasWifi = true;
        this.screenSize = 5;
    }

    @Override
    public void sendSMS(String number, String message) {
        super.sendSMS(number, message);
        System.out.println("SamsungS4 class is sending sms " + "Hello " + message + " to " + number);
    }
}
