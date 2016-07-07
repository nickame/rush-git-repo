package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nickame on 12.04.16.
 */
class DepositCommand implements Command
{
    private ResourceBundle res=ResourceBundle.getBundle(RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {

        String c = ConsoleHelper.askCurrencyCode();
        String[] s = ConsoleHelper.getValidTwoDigits(c);
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(c);
        currencyManipulator.addAmount(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),Integer.parseInt(s[0])*Integer.parseInt(s[1]),c));

    }
}
