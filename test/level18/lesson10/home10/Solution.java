package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner=new Scanner(System.in);
        String fileName=scanner.nextLine();
        TreeSet<String> set = new TreeSet<>();
        while (!fileName.equals("end"))
        {
            set.add(fileName);
            fileName=scanner.nextLine();
        }
        String fileOutName = set.first().substring(0, set.first().lastIndexOf('.'));
        FileInputStream fileIN;
        FileOutputStream fileOut = new FileOutputStream(fileOutName);
        for (String s : set)
        {
            fileIN=new FileInputStream(s);
            byte[] buff = new byte[fileIN.available()];
            fileIN.read(buff);
            fileOut.write(buff);
            fileIN.close();
        }

        fileOut.close();
        scanner.close();

    }
}
