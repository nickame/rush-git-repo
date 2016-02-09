package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream file = new FileInputStream(args[0]);
        int couunt=0;
        while (file.available()>0)
        {
            int n=file.read();
            if((n>='a')&(n<='z')||(n>='A')&(n<='Z')) couunt++;
        }
        System.out.println(couunt);
        file.close();
    }
}
