package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nickame on 12.04.16.
 */
class InfoCommand implements Command
{
    private ResourceBundle res=ResourceBundle.getBundle(RESOURCE_PATH + "info_en");
    @Override
    public void execute()
    {
        boolean hasMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
       for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()){

            if(currencyManipulator.hasMoney())
            {

                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
                hasMoney=true;

            }
        }
        if(!hasMoney)
        ConsoleHelper.writeMessage(res.getString("no.money"));

    }
}
