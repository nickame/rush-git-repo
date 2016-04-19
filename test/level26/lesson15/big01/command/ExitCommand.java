package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by nickame on 12.04.16.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("exit y/n");
        String flag;
        flag = ConsoleHelper.readString().toLowerCase();
        if (flag.equals("y"))
        {
            ConsoleHelper.writeMessage("fuck you:)");


        }
    }
}



