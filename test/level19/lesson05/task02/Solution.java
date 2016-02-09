package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new FileInputStream(scanner.nextLine()));
        String str = "";
        int count = 0;
        while (fileScanner.hasNextLine())
            str = str + " " + fileScanner.nextLine();
        String[] wolds = str.replaceAll("\\p{Punct}+", " ").split(" ");
        for (String s : wolds)
        {

            if ("world".equals(s))
            {
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
        fileScanner.close();
    }
}
