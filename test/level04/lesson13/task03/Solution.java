package com.javarush.test.level04.lesson13.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i,j;
        for(i=1; i<11; i++)
        {
            for(j=1; j<=i; j++)
            {
                System.out.print("8");
            }
            j=1;
            System.out.println();
        }
        //Напишите тут ваш код

    }
}
