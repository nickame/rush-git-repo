package com.javarush.test.level04.lesson13.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Все любят Мамбу
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: [*имя* любит меня.]
Пример текста:
Света любит меня.
Света любит меня.
…
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i;
        String name;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

       name = reader.readLine();

       for(i=0; i<10; i++)//Напишите тут ваш код
        {
            System.out.println(name+" любит меня.");
        }
    }
}
