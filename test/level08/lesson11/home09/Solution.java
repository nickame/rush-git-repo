package com.javarush.test.level08.lesson11.home09;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        //isDateOdd("Jan 1 2000");
        //System.out.println(isDateOdd("Jan 3 2000"));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {

        String startyear;
        Date dayyear;
        SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        dayyear = format.parse(date);
        SimpleDateFormat format1 = new SimpleDateFormat("D", Locale.ENGLISH);
        startyear =format1.format(dayyear);

        //if((((dayyear.getTime()-startyear.getTime())/(1000*60*24))%2)==0)
        if((Integer.parseInt(startyear)%2)==0)
            return false;
        else

        return true;
    }
}
