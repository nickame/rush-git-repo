package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nickame on 09.06.15.
 */

 class RussianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 3;}
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}