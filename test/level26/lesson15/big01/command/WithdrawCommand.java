package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by nickame on 12.04.16.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    { //1.1. Считать код валюты (метод уже есть)
        String code = ConsoleHelper.askCurrencyCode();
        //1.2. Получить манипулятор для этой валюты.
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        // 1.3. Пока пользователь не введет корректные данные выполнять:
        while (true)
        {
            // 1.3.1. Попросить ввести сумму
            int summa = -1;
            ConsoleHelper.writeMessage("Enter summ:");
            try
            {
                summa = Integer.parseInt(ConsoleHelper.readString());
                if (summa < 0) throw new Exception();
            }
            //1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.

            catch (Exception e)
            {
                ConsoleHelper.writeMessage("Error try again");
                continue;
            }
            //1.3.3. Проверить, достаточно ли средств на счету.
            if (!currencyManipulator.isAmountAvailable(summa)) continue;

            //1.3.4. Списать деньги со счета.
            TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            try
            {
                map.putAll(currencyManipulator.withdrawAmount(summa));
                //1.3.5. Вывести пользователю результат из п. 1.3.4.
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                }
                ConsoleHelper.writeMessage("Success");
                break;
            }
            //1.3.6. Перехватить исключение NotEnoughMoneyException, уведомить юзера о нехватке банкнот и вернуться к п. 1.3.
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("There is no such denominations");
                continue;
            }
        }

    }
}
