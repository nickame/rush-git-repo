package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nickame on 09.06.15.
 */
class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth(){return 5;}
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

