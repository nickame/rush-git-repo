package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double zan;
    public Money(double amount)
    {
        zan=amount;
    }

    public  double getAmount()
    {

        return  zan;
    }

    public abstract String getCurrencyName();
}

