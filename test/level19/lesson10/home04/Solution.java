package com.javarush.test.level19.lesson10.home04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner=new Scanner(System.in);
        Scanner fileScanner = new Scanner(new FileInputStream(scanner.nextLine()));
        String str;
        int count=0;
        while (fileScanner.hasNextLine())
        {
           str=fileScanner.nextLine();
            String[] s = str.split(" ");
            for(String s1 : words)
            {
                for(String s2 : s)
                {
                    if (s1.equals(s2)) count++;
                }
            }
            if (count==2)
            {
                System.out.println(str);
            }
          count=0;
        }
        fileScanner.close();
        scanner.close();
    }
}
