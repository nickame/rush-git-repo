package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        System.out.println(naibObschDel(a, b));
    }

    public static int naibObschDel(int a, int b)
    {
        int c = 1, d = 1;
        while ((a / c >= 1) && (b / c >= 1))
        {
            if ((a % c == 0) && (b % c == 0))
                d = c;
            c++;
        }
        return d;
    }
}
