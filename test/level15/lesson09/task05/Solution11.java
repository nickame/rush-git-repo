package com.javarush.test.level15.lesson09.task05;

/**
 * Created by nickame on 23.07.15.
 */
public class Solution11
{
    public static Object cat;

    {
        Pet myCat = new Pet();
        cat = (Object) myCat;
        System.out.println(myCat.name);
    }

    public class Pet
    {
        String name = "Пушок";
    }
}
