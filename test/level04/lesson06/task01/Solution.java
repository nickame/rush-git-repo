package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static int Minimum1(int a,int b)
    {
        int c;

        if (a<b)
        {
            c=a;
        }
        else
        {
            c=b;
        }
        return (c);
    }




    public static void main(String[] args) throws Exception
    {
       int a,b,rez;
       String as,bs;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        as = reader.readLine();
        a=Integer.parseInt(as);



        bs=reader.readLine();
        b=Integer.parseInt(bs);


        rez=Minimum1(a,b);
        System.out.println(rez);



        //Напишите тут ваш код

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}