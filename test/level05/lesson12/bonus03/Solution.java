package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum=0;
        String as=as = reader.readLine();
        int a=Integer.parseInt(as);
        if(a>0)
        {
            String bs = reader.readLine();
            int b = Integer.parseInt(bs);
            maximum=b;
            for (int i = 0; i < a-1; i++)
            {
                 bs = reader.readLine();
                 b = Integer.parseInt(bs);
                if (b > maximum)
                {
                    maximum = b;
                }
            }
        }

        //напишите здесь ваш код




        System.out.println(maximum);
    }
}
