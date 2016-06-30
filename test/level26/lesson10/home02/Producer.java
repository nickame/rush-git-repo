package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nickame on 18.06.16.
 */
public class Producer extends Thread
{
    protected ConcurrentHashMap<String, String> map;
    public Producer(ConcurrentHashMap<String, String> map){
        this.map=map;
    }

    @Override
    public void run()
    {
       long i=1;
        while(true){
            try
            {

                System.out.println("Some text for " + i++);
                sleep(500);

            }
            catch (InterruptedException e)
            {
                System.out.println("["+currentThread().getName()+"] thread was terminated");
                break;

            }

        }

    }
}
