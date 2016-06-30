package com.javarush.test.level25.lesson05.home01;


public class LoggingStateThread extends Thread
{
    Thread target;
    State state, previosstate;


    public LoggingStateThread(Thread target)
    {
        this.target = target;
        previosstate = state = this.target.getState();
        System.out.println(state);
        this.setDaemon(true);
    }

    public void run()
    {

        do
        {
            state = target.getState();
            if (state != previosstate)
            {
                System.out.println(state);
                previosstate = state;
            }
        }
        while (state != State.TERMINATED);


    }

}