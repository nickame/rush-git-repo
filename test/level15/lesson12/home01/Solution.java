package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        {
            String value = reader.readLine();
            while (!value.equals("exit"))
            {
                try
                {
                    if (!(value.indexOf(".") == -1))
                    {
                        print(Double.parseDouble(value));
                    } else if (0 < Integer.parseInt(value) && Integer.parseInt(value) < 128)
                    {
                        print(Short.parseShort(value));
                    } else if (Integer.parseInt(value) >= 128)
                    {
                        print(Integer.parseInt(value));
                    } else
                    {
                        print(value);
                    }
                }
                catch (NumberFormatException e)
                {
                    print(value);
                }

                value = reader.readLine();

            }
        }
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
