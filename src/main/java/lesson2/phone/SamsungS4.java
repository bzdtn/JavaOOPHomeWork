package lesson2.phone;

public class SamsungS4 extends Phone {

    public SamsungS4(){
        System.out.println("SamsungS4 constructor");
        this.touch = false;
        this.hasWifi = true;
        this.screenSize = 5;
    }

    @Override
    protected void sendOutSMS(String number, String message) {
        System.out.println("SamsungS4 class is sending sms " + "Hello " + message + " to " + number);
    }
}
