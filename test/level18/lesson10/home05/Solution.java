package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
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
        FileOutputStream file2=new FileOutputStream(f2);

        byte[] buff = new byte[file1.available()];
        file1.read(buff);
        char[] chars= new char[buff.length];
        for (int i=0; i<buff.length; i++)
        {
            chars[i]=(char)buff[i];
        }
        String str=String.valueOf(chars);

        String[] strbuff=str.split(" ");
        long[] num=new long[strbuff.length];
        for (int i =0 ; i< strbuff.length; i++)
            {
                num[i]=Math.round(Double.parseDouble(strbuff[i]));
            }
        String tr="";
                tr=tr+num[0];

        for (int i =1 ; i< num.length; i++)
        tr=tr + " " + num[i];

      byte[] sbuff = new byte[tr.length()];
        sbuff=tr.getBytes();
        file2.write(sbuff);
        file1.close();
        file2.close();

    }
}
