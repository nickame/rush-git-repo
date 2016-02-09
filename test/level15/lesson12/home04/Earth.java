package com.javarush.test.level15.lesson12.home04;

/**
 * Created by nickame on 24.07.15.
 */
public class Earth implements Planet
{
    private static Earth _instance = null;

    private Earth() {}

    public static synchronized Earth getInstance() {
        if (_instance == null)
            _instance = new Earth();
        return _instance;
    }
}
