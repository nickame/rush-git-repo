package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }


    public static  int max(int i, int j)
    {
        if (i<j)
            return j;
        else return i;
    }
    public static long max(long i, long j)
    {
        if (i<j)
            return j;
        else return i;
    }
    public static double max(double i, double j)

    {
        if (i<j)
            return j;
        else return i;
    }
}