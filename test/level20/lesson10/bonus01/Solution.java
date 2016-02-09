package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
//    public static void main(String[] args)
//    {
//        long memoryStart = Runtime.getRuntime().freeMemory();
//        Long t0 = System.currentTimeMillis();
//
//        //      534494836
//        for (int f : getNumbers(534494836))
//            System.out.println(f);
//
//        long memoryEnd = Runtime.getRuntime().freeMemory();
//        long memoTaken = memoryStart - memoryEnd; // итог получаем байты.
//        Long t1 = System.currentTimeMillis();
//        System.out.println("Time need to create the arrray = " + (t1 - t0) / 1000 + "s");
//        System.out.println("Memory needed = " + memoTaken / 1024 / 1024 + "mb");
//
//
//    }

    public static int[] getNumbers(int N)
    {
        int[] result = null;
        List<Integer> prerezult = new ArrayList<>();

        String s = String.valueOf(N);
        int stepp=s.length()+1;
        int[][] step = new int[stepp][10];

        for (int p = 0; p < 10; p++)
        {
            step[0][p] = p;
        }
        for (int p = 0; p < stepp; p++)
        {
            step[p][0] = p;
        }
        for (int p = 1; p < stepp; p++)
        {
            for (int t = 1; t < 10; t++)
            {
                step[p][t] = step[p-1][t]*step[0][t];
            }
        }
        for (int i = 1; i <= N; i++)
        {
            s = String.valueOf(i);


            int rez = 0, ind = 10;
            for (int k = 0; k < s.length(); k++)
            {
                int prom = (i % ind - i % (ind / 10)) / (ind / 10);
                if(prom==0);
                else
                rez = rez + step[s.length()-1][prom];
                ind *= 10;
            }
                if (rez == i)
            {
                prerezult.add(rez);
            }
        }
        result = new int[prerezult.size()];
        for (int kk = 0; kk < prerezult.size(); kk++)
            result[kk] = prerezult.get(kk);
        return result;
    }
}
