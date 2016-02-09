package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        String f2=reader.readLine();
        reader.close();
        FileInputStream file1=new FileInputStream(f1);
        FileInputStream file2=new FileInputStream(f2);
        byte[] buff1 = new byte[file1.available()];
        byte[] buff2 = new byte[file2.available()];
        file2.read(buff2);
        file1.read(buff1);
        file1.close();
        file2.close();
        byte[] buff3= new byte[buff1.length+buff2.length];
        for(int i=0; i<buff2.length; i++)
        {
            buff3[i]=buff2[i];
        }
        for (int i=buff2.length; i<buff3.length; i++)
        {
            buff3[i]=buff1[i-buff2.length];
        }

        FileOutputStream file3 = new FileOutputStream(f1);
        file3.write(buff3);
        file3.close();

    }
}
