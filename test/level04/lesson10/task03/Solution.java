package com.javarush.test.level04.lesson10.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i=0, b;
        String as,bs;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        as = reader.readLine();

        bs=reader.readLine();
        b=Integer.parseInt(bs);//Напишите тут ваш код

        while (i<b)
        {
            System.out.println(as);
            i++;
        }

    }
}
