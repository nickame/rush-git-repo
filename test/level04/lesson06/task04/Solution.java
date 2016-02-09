package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String as,bs;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        as=reader.readLine();
        bs=reader.readLine();

        if (as.equals(bs))
        {
            System.out.println("Имена идентичны");
        }
        else  if (as.length()==bs.length())
        {
            System.out.println("Длины имен равны");
        }

    }
}
