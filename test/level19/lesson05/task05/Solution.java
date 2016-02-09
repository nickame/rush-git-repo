package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new FileInputStream(scanner.nextLine()));
        String str = "";
        while (fileScanner.hasNextLine())
            str = str + "\n " + fileScanner.nextLine();
         str=str.replaceAll("\\p{Punct}", "");
        FileWriter fileWriter=new FileWriter(new File(scanner.nextLine()));
        fileWriter.write(str);
        fileWriter.close();
        scanner.close();
        fileScanner.close();
    }

}
