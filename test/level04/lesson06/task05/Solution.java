package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {String s;
        String name;
        int age;


        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        name=reader.readLine();
        s=reader.readLine();
        age=Integer.parseInt(s);
        if (age<18)
        {
            System.out.println("Подрасти еще");
        }

    }
}
