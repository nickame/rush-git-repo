package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nickame on 09.06.15.
 */
public class BelarusianHen extends Hen


    {
        int getCountOfEggsPerMonth(){return 6;}
        String getDescription()
        {
            return (super.getDescription()+" Моя страна - " +Country.BELARUS + ". Я несу " +getCountOfEggsPerMonth()+" яиц в месяц.");
        }
    }

