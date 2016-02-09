package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s* \\s*");
        Scanner fileScanner = new Scanner(new FileInputStream(scanner.nextLine()));
        FileWriter fileWriter = new FileWriter(scanner.nextLine());
        String str = "";
        while (fileScanner.hasNext())
        {
            if (fileScanner.hasNextInt())
            {
                str = str + String.valueOf(fileScanner.nextInt()) + " ";
            } else fileScanner.next();
        }
        fileWriter.write(str);
        scanner.close();
        fileScanner.close();
        fileWriter.close();
    }
}
