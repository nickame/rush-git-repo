package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nickame on 30.06.16.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "login_en");

    String tempCard, tempPin;


    @Override
    public void execute() throws InterruptOperationException
    {
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            tempCard = ConsoleHelper.readString();
            tempPin = ConsoleHelper.readString();
            if (tempCard.length()!=12)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }  if (tempPin.length()!=4)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }
            if ((validCreditCards.containsKey(tempCard)) && validCreditCards.getString(tempCard).equals(tempPin))
            {
                String message=String.format(res.getString("success.format"),tempCard);
                ConsoleHelper.writeMessage(message);
                break;
            }

        }

    }
}
