package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] s1=s.split("");
       // if(!s1[0].equals(" "));
            s1[1]=s1[1].toUpperCase();
        for (int i=1;i< s1.length;i++)
        {
            if ((!s1[i].equals(" "))&&(s1[i-1].equals(" ")))
            {
                s1[i]=s1[i].toUpperCase();
            }
        }




        for(String w : s1)

        System.out.print(w);

        //Напишите тут ваш код
    }


}
