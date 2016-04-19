package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by nickame on 12.04.16.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
