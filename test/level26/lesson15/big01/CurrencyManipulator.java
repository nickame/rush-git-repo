package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickame on 11.04.16.
 */
public class CurrencyManipulator
{
    String currencyCode;

    Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {

        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){

        if(denominations.containsKey(denomination))
        {
          count =  denominations.get(denomination) + count;
        }
        denominations.put(denomination,count);

    }
    public int getTotalAmount(){
        int result=0;

        for (Integer i : denominations.keySet())
        result=+denominations.get(i)*i;

        return result;
    }

    public boolean hasMoney(){
    return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount>=getTotalAmount();
    }

    Map<Integer, Integer> withdrawAmount(int expectedAmount){
        return null;
    }
}
