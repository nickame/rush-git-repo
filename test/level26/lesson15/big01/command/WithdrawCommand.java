package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by nickame on 12.04.16.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {   //1.1-1.2
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        //1.3 - 1.3.3
        int summ=0;
        while (true){
            ConsoleHelper.writeMessage("enter summ:");
            try{
                summ=Integer.parseInt(ConsoleHelper.readString());
            }
            catch (InterruptOperationException e){throw new InterruptOperationException();}
            catch (Exception e){ continue; }
            if(!currencyManipulator.isAmountAvailable(summ))
            {
                ConsoleHelper.writeMessage("not enough money");
                continue;
            }
            else break;
        }
        //1.3.4

    }
}
