package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sours=reader.readLine();
        FileInputStream inputStream = new FileInputStream(sours);
        int count=0;
        while (inputStream.available()>0)
        {
            if (inputStream.read()==',') count++;
        }
        System.out.println(count);
        reader.close();
        inputStream.close();
    }
}
