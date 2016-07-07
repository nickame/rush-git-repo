package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nickame on 12.04.16.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res =
            ResourceBundle.getBundle(RESOURCE_PATH + "withdraw_en");

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
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try
            {
                summa = Integer.parseInt(ConsoleHelper.readString());
                if (summa < 0) throw new Exception();
            }
            //1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.

            catch (Exception e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            //1.3.3. Проверить, достаточно ли средств на счету.
            if (!currencyManipulator.isAmountAvailable(summa)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

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
                String success=String.format(res.getString("success.format"), summa, code);
                ConsoleHelper.writeMessage(success);
                break;
            }
            //1.3.6. Перехватить исключение NotEnoughMoneyException, уведомить юзера о нехватке банкнот и вернуться к п. 1.3.
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            catch (ConcurrentModificationException ignor){}
        }

    }
}
