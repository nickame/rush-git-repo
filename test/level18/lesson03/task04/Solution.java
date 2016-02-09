package com.javarush.test.level18.lesson03.task04;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream file = new FileInputStream(/*"/home/nickame/1.txt"*/name);
        int data, k=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();


        while (file.available() > 0)
        {
            data=file.read();
            map.put(data,1);
        }
        for(int i=0; i<list.size();i++)
            for (Map.Entry<Integer, Integer> pair : map.entrySet())
            {
                if (pair.getKey().equals(list.get(i)))
                    pair.setValue(pair.getValue() + 1);
                k=pair.getValue();
            }

        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue()<k) k=pair.getValue();
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue().equals(k))
                System.out.println(pair.getKey());
        }


       // System.out.println(map);

        file.close();


    }

}
