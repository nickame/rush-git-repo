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
        result=result+denominations.get(i)*i;

        return result;
    }

    public boolean hasMoney(){
    return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return getTotalAmount()>=expectedAmount;
    }

   public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        List<Integer> bancnots = new ArrayList<>();
        List<Integer> bancnotstemp = new ArrayList<>();
        List<List<Integer>> resultlist = new ArrayList<>();
        Map<Integer,Integer> result = new ConcurrentHashMap<>();
        for(Integer i : denominations.keySet())
            for (int j = 0; j < denominations.get(i) ; j++)
            {
                bancnots.add(i);
            }
        Collections.sort(bancnots, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2-o1;
            }
        });

        while (true){
            int summ=expectedAmount;
            int summList=0;
            for (Integer i : bancnots) summList= summList+i;
            if(summList>=expectedAmount){
                for(Integer i : bancnots){
                    if(summ-i>=0){
                        summ=summ-i;

                        bancnotstemp.add(i);
                    }
                }
            }
            else break;
            if(summ==0){
                resultlist.add(bancnotstemp);
            }
            if(bancnots.size()>=1)
            bancnots.remove(0);
            else break;
            bancnotstemp=new ArrayList<>();


        }
        if(resultlist.size()==0) throw  new NotEnoughMoneyException();
        int min = resultlist.get(0).size();

        for (int i = 0; i < resultlist.size() ; i++)
        {
            if(resultlist.get(i).size()<min) min=resultlist.get(i).size();
        }
        if (min==0) throw new NotEnoughMoneyException();
        for (int i = 0; i <resultlist.size() ; i++)
        {
            if(resultlist.get(i).size()==min){
                for (Integer listItem : resultlist.get(i)){
                    if(result.containsKey(listItem)) result.put(listItem,result.get(listItem)+1);
                    else result.put(listItem,1);
                }
               break;
            }
        }
        try
        {
            for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
            {
                if (result.containsKey(entry.getKey()))
                    if (entry.getValue() - result.get(entry.getKey()) == 0) denominations.remove(entry.getKey());
                    else denominations.put(entry.getKey(), entry.getValue() - result.get(entry.getKey()));
            }
        }
        catch (ConcurrentModificationException ignor){}



        return result;
    }
}

