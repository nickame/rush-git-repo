package com.javarush.test.level15.lesson12.home04;

/**
 * Created by nickame on 24.07.15.
 */
public class Moon implements Planet
{
    private static Moon _instance = null;

    private Moon() {}

    public static synchronized Moon getInstance() {
        if (_instance == null)
            _instance = new Moon();
        return _instance;
    }
}
