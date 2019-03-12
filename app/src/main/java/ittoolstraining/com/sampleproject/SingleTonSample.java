package ittoolstraining.com.sampleproject;

public class SingleTonSample {

    private static SingleTonSample instance;

    private SingleTonSample()
    {
        if(instance!=null)
        {
            throw new RuntimeException("Please use getinstance method to access");
        }
    }

    public static SingleTonSample getInstance()
    {
        if(instance == null)
        {
            synchronized (SingleTonSample.class) {

                if(instance == null) {
                    instance = new SingleTonSample();
                }
            }
        }
        return instance;
    }

}
