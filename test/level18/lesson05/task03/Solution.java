package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        String f2=reader.readLine();
        String f3=reader.readLine();
        FileInputStream file1 = new FileInputStream(f1);
        FileOutputStream file2 = new FileOutputStream(f2);
        FileOutputStream file3 = new FileOutputStream(f3);
        if ((file1.available()%2)==0)
        {
            byte[] buff = new byte[file1.available()];
            int count=file1.read(buff);
            file2.write(buff,0,count/2);
            byte[] buff2=new byte[count/2];
            int i = count/2, j=0;
            while (i<buff.length)
            {
                buff2[j]=buff[i];
                i++; j++;
            }
            file3.write(buff2);
        }
        else
        {
            byte[] buff = new byte[file1.available()];
            int count=file1.read(buff);
            file2.write(buff,0,count/2+1);
            byte[] buff2=new byte[count/2];
            int i = count/2+1, j=0;
            while (i<buff.length)
            {
                buff2[j]=buff[i];
                i++; j++;
            }
            file3.write(buff2);
        }

        reader.close();
        file1.close();
        file2.close();
        file3.close();


    }
}
