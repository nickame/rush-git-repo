package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by nickame on 12.04.16.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String c = ConsoleHelper.askCurrencyCode();
        String[] s = ConsoleHelper.getValidTwoDigits(c);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(c);
        currencyManipulator.addAmount(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

    }
}
