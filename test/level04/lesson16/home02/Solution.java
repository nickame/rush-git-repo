package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {

        int a, b, c;
        String as,bs,cs;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        as = reader.readLine();
        a=Integer.parseInt(as);



        bs=reader.readLine();
        b=Integer.parseInt(bs);

        cs=reader.readLine();
        c=Integer.parseInt(cs);//Напишите тут ваш код



        int i=0, r;
        while (i!=1)
        {
            if (a < b)
            {
                r = a;
                a = b;
                b = r;
            }

            if (b < c)
            {
                r = b;
                b = c;
                c = r;
            }
            if (a>b && b>c)
                i=1;
        }

        System.out.println(b); //Напишите тут ваш код
    }
}
