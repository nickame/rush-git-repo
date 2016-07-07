package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nickame on 12.04.16.
 */
class ExitCommand implements Command
{
    private ResourceBundle res= ResourceBundle.getBundle(RESOURCE_PATH + "exit_en");
    @Override
    public void execute() throws InterruptOperationException
    {

        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String flag;
        flag = ConsoleHelper.readString().toLowerCase();
        if (flag.equals(res.getString("yes")))
        {
            ConsoleHelper.writeMessage(res.getString("thank.message"));


        }
    }
}



