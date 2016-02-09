package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        String f2=reader.readLine();
        FileInputStream file1 = new FileInputStream(f1);
        FileOutputStream file2 = new FileOutputStream(f2);

        if(file1.available()>=0)
        {
            byte[] buff = new byte[file1.available()];
            file1.read(buff);

            for (int i = buff.length-1; i>=0; i--)
            {
                file2.write(buff[i]);
            }
        }
        reader.close();
        file1.close();
        file2.close();
    }
}
