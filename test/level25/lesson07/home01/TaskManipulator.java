package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    String threadName;
    Thread thread;

    @Override
    public void run()
    {
        try
        {
//            if(!thread.isInterrupted())
//            System.out.println(threadName);


            while (!thread.isInterrupted())
            {
                thread.sleep(0);
                System.out.println(threadName);
                thread.sleep(90);
            }
        }
        catch (Exception e)
        {
        }
    }

    @Override
    public void start(String threadName)
    {
        thread = new Thread(this);
        this.threadName = threadName;
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();

    }
}
