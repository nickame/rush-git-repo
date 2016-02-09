package com.javarush.test.level15.lesson12.home04;

/**
 * Created by nickame on 24.07.15.
 */
public class Sun implements Planet
{
    private static Sun _instance = null;

    private Sun() {}

    public static synchronized Sun getInstance() {
        if (_instance == null)
            _instance = new Sun();
        return _instance;
    }
}
