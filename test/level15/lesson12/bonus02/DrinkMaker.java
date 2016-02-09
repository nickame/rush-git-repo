package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Nick on 01.08.2015.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
