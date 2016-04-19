package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nickame on 11.04.16.
 */
public class ConsoleHelper
{
    public static void writeMessage(String message)
    {

        System.out.println(message);

    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws InterruptOperationException
    {

        String result="";
        try
        {
             result=reader.readLine();
            if(result.toLowerCase().equals("exit")) throw new InterruptOperationException();


        }
        catch (IOException e){
        }

        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String currencyCode = null;
        writeMessage("Введите код валюты ");
        while (true)
        {
            currencyCode = readString();
            if (currencyCode.length() == 3 && currencyCode.replaceAll(" ", "").length() == 3)
            {
                return currencyCode.toUpperCase();
            } else
            {
                writeMessage(" Ошибка ввода - повторите.");
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("Ввести два целых положительных числа(номинал количество)");
        String[] resalt;
        while (true)
        {
            resalt = readString().split(" ");
            try
            {
                if (resalt.length == 2 && Integer.parseInt(resalt[0]) >= 0 && Integer.parseInt(resalt[1]) >= 0)
                    return resalt;
            }

            catch (Exception e)
            {
            }
            writeMessage(" Ошибка ввода - повторите.");

        }
    }

    public static Operation askOperation() throws InterruptOperationException{

        writeMessage("Выберите операцию:\n1 - INFO\n2 - DEPOSIT\n3 - WITHDRAW\n4 - EXIT");

            while (true){

                try
                {
                    String str = readString();
                    Integer i = Integer.parseInt(str);
                    return Operation.getAllowableOperationByOrdinal(i);
                }
                catch (InterruptOperationException e){
                    throw new InterruptOperationException();
                }
                catch (Exception e){
                    writeMessage("error - try again");
                }

        }
    }
}
