package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array=new int[20];
        int[] arr1=new int[10];
        int[] arr2=new int[10];

        for (int i=0; i<20; i++)
        {
            array[i]=Integer.parseInt( reader.readLine());
        }
        for (int i=0; i<10; i++)
        {
            arr1[i]=array[i];
            arr2[i]=array[i+10];
            System.out.println(arr2[i]);
        }

        //Напишите тут ваш код

    }
}
