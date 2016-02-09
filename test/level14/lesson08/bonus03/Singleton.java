package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by nickame on 25.07.15.
 */
public class Singleton
{
    private static Singleton _instance = null;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (_instance == null)
            _instance = new Singleton();
        return _instance;
    }
}
