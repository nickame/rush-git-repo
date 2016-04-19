package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by nickame on 12.04.16.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean hasMoney = false;
       for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()){

            if(currencyManipulator.hasMoney())
            {

                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                hasMoney=true;

            }
        }
        if(!hasMoney)
        ConsoleHelper.writeMessage("No money available.");

    }
}
