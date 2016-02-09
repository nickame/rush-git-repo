package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream file = new FileInputStream(name);

        int minbyte=file.read(), data;
        while (file.available()>0)
        {
            data=file.read();
            if (minbyte>data) minbyte=data;
        }
        System.out.println(minbyte);
        file.close();

    }
}
