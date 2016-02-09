package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new Treadone());
        threads.add(new Treadtwo());
        threads.add(new Treadtree());
        threads.add(new Treadfour());
        threads.add(new Treadfive());
    }


    public static class Treadone extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {

            }

        }
    }

    public static class Treadtwo extends Thread
    {
        @Override
        public void run()
        {
            try
            {

                sleep(10000);
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class Treadtree extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                System.out.println("Ура");
                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Treadfour extends Thread implements Message
    {
        @Override
        public void run()
        {
            while (!isInterrupted());
        }

        @Override
        public void showWarning()
        {
            interrupt();
            try
            {
                join();
            }
            catch (InterruptedException e)
            {
            }

        }
    }

    public static class Treadfive extends Thread
    {
        @Override
        public void run()
        {
            int sum = 0;
            String str = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                str = reader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            while (!str.equals("N"))
            {
                sum = sum + Integer.parseInt(str);
                try
                {
                    str = reader.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);

        }
    }

}