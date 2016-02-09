package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        String f1=scanner.nextLine();
        String f2=scanner.nextLine();
        scanner.close();
        FileInputStream file1=new FileInputStream(f1);
        FileOutputStream file2=new FileOutputStream(f2);
        byte[] buff=new byte[file1.available()];
        file1.read(buff);
        for (int i=1; i<buff.length; i=i+2)
        {
            file2.write((int)buff[i]);
        }
    }
}
