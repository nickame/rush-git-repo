package com.javarush.test.level14.lesson08.home09;

/**
 * Created by nickame on 11.06.15.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
