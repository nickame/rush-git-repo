package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream file = new FileInputStream(name);
        int data;
        TreeSet <Integer> set= new TreeSet<>();
       // ArrayList<Integer> list = new ArrayList<>();


        while (file.available() > 0)
        {
            data=file.read();
            set.add(data);
        }
        for(int s : set)
        System.out.print(s+" ");
//        list.addAll(set);
//
//        for (int i=0; i<list.size();i++)
//            for (int j=list.size()-1; j>i; j--)
//                if (list.get(i)>list.get(j))
//                {
//                    k=list.get(i);
//                    list.set(i , list.get(j));
//                    list.set(j,k);
//                }
//
//        System.out.println(list);
        file.close();
    }
}
