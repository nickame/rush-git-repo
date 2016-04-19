package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickame on 11.04.16.
 */
public final class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {
    }

    public static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
     CurrencyManipulator curent;
        if(map.containsKey(currencyCode)) curent=map.get(currencyCode);
        else{ curent=new CurrencyManipulator(currencyCode);
        map.put(currencyCode,curent);
        }

        return curent;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){

        return map.values();

    }


}
