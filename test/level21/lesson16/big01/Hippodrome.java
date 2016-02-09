package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by nickame on 07.02.16.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse h1 = new Horse("h1", 3, 0);
        Horse h2 = new Horse("h2", 3, 0);
        Horse h3 = new Horse("h3", 3, 0);
        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();

    }

    public void run()
    {
        for (int i = 1; i < 101; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void move()
    {
        for (Horse h : horses)
        {
            h.move();
        }
    }

    public void print()
    {
        for (Horse h : horses)
        {
            h.print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        Horse h=horses.get(0);
        for(int i=1; i<horses.size();i++)
            if(h.getDistance()<horses.get(i).getDistance())
                h=horses.get(i);

        return h;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}
