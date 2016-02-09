package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        while (!f1.equals(""))
        {
             f1=reader.readLine();
            FileInputStream file1 = new FileInputStream(f1);
            if (file1.available() < 1000)
            {
                reader.close();
                file1.close();
                throw new DownloadException();
            }
        }


    }

    public static class DownloadException extends Exception{

    }
}
