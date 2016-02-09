package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {

        int a=0, b=0;
        String as;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (a!=-1)
        {
            as = reader.readLine();
            a = Integer.parseInt(as); //Напишите тут ваш код
          b=b+a;

        }
        System.out.println(b);
    }
}
