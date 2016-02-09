package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
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

        System.out.println(a+" "+b+" "+c);
    }
}
