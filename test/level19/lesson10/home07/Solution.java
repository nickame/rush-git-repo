package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner fileScanner=new Scanner(new FileInputStream(args[0]));
        String str="", s="";
        while (fileScanner.hasNext())
        {
            str=fileScanner.nextLine();
            String[] s1=str.split(" ");
            for(String s2 : s1)
            {
                if (s2.length()>6) s=s+s2+",";
            }
        }
        s=s.substring(0,s.length()-1);
        FileWriter fileWriter = new FileWriter(args[1]);
        fileWriter.write(s);
        fileScanner.close();
        fileWriter.close();

    }
}
