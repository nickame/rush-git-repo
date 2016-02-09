package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
        public static int Minimum1(int a,int b)
        {
            int z;

            if (a>b)
            {
                z=a;
            }
            else
            {
                z=b;
            }
            return (z);
        }




    public static void main(String[] args) throws Exception
    {
        int a,b,c,d,rez1,rez2,rez3;
        String as,bs,cs,ds;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        as = reader.readLine();
        a=Integer.parseInt(as);



        bs=reader.readLine();
        b=Integer.parseInt(bs);

        cs=reader.readLine();
        c=Integer.parseInt(cs);



        ds=reader.readLine();
        d=Integer.parseInt(ds);

        rez1=Minimum1(a,b);
        rez2=Minimum1(c,d);
        rez3=Minimum1(rez1,rez2);
        System.out.println(rez3);
//Напишите тут ваш код

    }
}
