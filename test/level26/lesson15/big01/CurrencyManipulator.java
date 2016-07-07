package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    public void addAmount(int denomination, int count)
    {

        if (denominations.containsKey(denomination))
        {
            count = denominations.get(denomination) + count;
        }
        denominations.put(denomination, count);

    }

    public int getTotalAmount()
    {
        int result = 0;

        for (Integer i : denominations.keySet())
            result = result + denominations.get(i) * i;

        return result;
    }

    public boolean hasMoney()
    {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> result = new ConcurrentHashMap<>();
        TreeMap<Integer, Integer> tempMap = new TreeMap<>(Collections.reverseOrder());
        tempMap.putAll(denominations);
        ArrayList<Integer> listOfDenominations = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listOfListOfDenominations = new ArrayList<>();
        while (true)
        {
            Integer tempSumm = expectedAmount;

            for (Map.Entry<Integer, Integer> pair : tempMap.entrySet())
            {
                for (int i = 0; i < pair.getValue(); i++)
                {
                    if ((tempSumm - pair.getKey()) >= 0)
                    {
                        tempSumm = tempSumm - pair.getKey();
                        listOfDenominations.add(pair.getKey());
                    }
                }
            }

            if (tempMap.isEmpty() && listOfListOfDenominations.size() == 0) throw new NotEnoughMoneyException();
            if (tempMap.isEmpty() && listOfListOfDenominations.size() > 0) break;
            if (tempSumm == 0)
            {
                listOfListOfDenominations.add(listOfDenominations);
            }

            tempMap.put(tempMap.firstKey(), tempMap.get(tempMap.firstKey()) - 1);
            if (tempMap.get(tempMap.firstKey()) == 0) tempMap.remove(tempMap.firstKey());

            listOfDenominations = new ArrayList<>();

        }

        int min = listOfListOfDenominations.get(0).size();
        for (ArrayList<Integer> llist : listOfListOfDenominations)
        {
            if (llist.size() < min) min = llist.size();
        }
        for (ArrayList<Integer> llist : listOfListOfDenominations)
        {
            if (llist.size() == min)
            {

                for (Integer rezint : llist)
                {

                    if (result.containsKey(rezint))
                    {
                        result.put(rezint, result.get(rezint) + 1);
                    } else result.put(rezint, 1);
                    if (denominations.containsKey(rezint))
                    {
                        denominations.put(rezint, denominations.get(rezint) - 1);
                        if (denominations.get(rezint) <= 0) denominations.remove(rezint);
                    }

                }
                break;
            }
        }
        return result;
    }


}

