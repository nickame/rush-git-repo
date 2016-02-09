package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nickame on 09.06.15.
 */
class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth(){return 4;}
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
