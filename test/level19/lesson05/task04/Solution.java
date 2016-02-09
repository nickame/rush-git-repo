package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileIn = new FileInputStream(scanner.nextLine());
        FileOutputStream fileOut = new FileOutputStream(scanner.nextLine());
        char c;
        while (fileIn.available()>0)
        {
            c=(char)fileIn.read();
            if (c=='.') c='!';
            fileOut.write((int)c);
        }
        scanner.close();
        fileIn.close();
        fileOut.close();
    }
}
