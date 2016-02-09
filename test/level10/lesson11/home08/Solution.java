package com.javarush.test.level10.lesson11.home08;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {

        ArrayList<String> array1 = new ArrayList<String>();
        ArrayList<String> array2 = new ArrayList<String>();
        ArrayList<String> array3 = new ArrayList<String>();
        array1.add("aaa");
        array1.add("bbb");
        array1.add("ccc");
        array2.add("ddd");
        array2.add("eee");
        array2.add("fff");
        array3.add("ggg");
        array3.add("hhh");
        array3.add("iii");
        ArrayList<String>[] arrayOfList = new ArrayList[]{array1, array2, array3};
       /* arrayOfList[0].addAll(array1);

        arrayOfList[1].addAll(array2);

        arrayOfList[2].addAll(array3);*/





        return arrayOfList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}