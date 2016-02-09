package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String monce= reader.readLine();

        switch (monce)
        {
            case ("January"):
            {
                System.out.println(monce + " is 1 month");
                break;
            }
            case ("February"):
            {
                System.out.println(monce + " is 2 month");
                break;
            }
            case ("March"):
            {
                System.out.println(monce + " is 3 month");
                break;
            }
            case ("April"):
            {
                System.out.println(monce + " is 4 month");
                break;
            }
            case ("May"):
            {
                System.out.println(monce + " is 5 month");
                break;
            }
            case ("June"):
            {
                System.out.println(monce + " is 6 month");
                break;
            }
            case ("July"):
            {
                System.out.println(monce + " is 7 month");
                break;
            }
            case ("August"):
            {
                System.out.println(monce + " is 8 month");
                break;
            }
            case ("September"):
            {
                System.out.println(monce + " is 9 month");
                break;
            }
            case ("October"):
            {
                System.out.println(monce + " is 10 month");
                break;
            }
            case ("November"):
            {
                System.out.println(monce + " is 11 month");
                break;
            }
            case ("December"):
            {
                System.out.println(monce + " is 12 month");
                break;
            }
        }

        //напишите тут ваш код
    }

}
