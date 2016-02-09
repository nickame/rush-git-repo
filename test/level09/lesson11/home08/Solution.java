package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        int[] i={1,2,3,4,5};
        int[] j={6,7};
        int[] k={8,9,10,11};
        int[] l={12,13,14,15,16,17,18};
        int[] h={};
        ArrayList<int[]> array=new ArrayList<int[]>();
                array.add(i);
                array.add(j);
                array.add(k);
                array.add(l);
                array.add(h);

         return array;                   //Написать тут ваш код
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
