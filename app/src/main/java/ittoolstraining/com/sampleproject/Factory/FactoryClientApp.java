package ittoolstraining.com.sampleproject.Factory;

public class FactoryClientApp {

    // No Abstraction , No Factory pattern implemented
    Mobile android = new Android();
    Mobile ios = new Ios();
    Mobile windows = new Windows();

    // Factory pattern implemented
    Mobile android1 = new MobileFactory().getMobile(1);
    Mobile ios1 = new MobileFactory().getMobile(2);
    Mobile windows1 = new MobileFactory().getMobile(3);


}
