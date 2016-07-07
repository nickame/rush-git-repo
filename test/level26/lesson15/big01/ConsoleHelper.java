package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nickame on 11.04.16.
 */
public class ConsoleHelper
{
    private static ResourceBundle res= ResourceBundle.getBundle(RESOURCE_PATH + "common_en");

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }


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
            if(result.toLowerCase().equals("exit")){
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }


        }
        catch (IOException e){
        }

        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String currencyCode = null;
        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {
            currencyCode = readString();
            if (currencyCode.length() == 3 && currencyCode.replaceAll(" ", "").length() == 3)
            {
                return currencyCode.toUpperCase();
            } else
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String message=String.format(res.getString("choose.denomination.and.count.format"),currencyCode);
        writeMessage(message);
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
            writeMessage(res.getString("invalid.data"));

        }
    }



    public static Operation askOperation() throws InterruptOperationException{

        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - "+res.getString("operation.INFO"));
        writeMessage("2 - "+res.getString("operation.DEPOSIT"));
        writeMessage("3 - "+res.getString("operation.WITHDRAW"));
        writeMessage("4 - "+res.getString("operation.EXIT"));


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
                catch (IllegalArgumentException t)
                {
                    writeMessage(res.getString("invalid.data"));
                }
        }
    }
}
