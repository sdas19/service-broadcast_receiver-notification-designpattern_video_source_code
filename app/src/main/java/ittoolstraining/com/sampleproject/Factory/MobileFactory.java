package ittoolstraining.com.sampleproject.Factory;

public class MobileFactory {

    Mobile getMobile(int key)
    {
        if(key == 1)
        {
            return new Android();
        }
        else if(key == 2)
        {
            return new Ios();
        }
        else
        {
            return new Windows();
        }
    }
}
