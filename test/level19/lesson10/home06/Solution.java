package com.javarush.test.level19.lesson10.home06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одинадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scannername = new Scanner(System.in);
        Scanner fileScanner =new Scanner(new FileInputStream(scannername.nextLine()));
        scannername.close();
        String s="";
        Set <Integer> keys = map.keySet();
        while (fileScanner.hasNextLine())
        {
           Scanner scanner = new Scanner(fileScanner.nextLine()).useDelimiter("\\s* \\s*");
            while (scanner.hasNext())
            {
                if (scanner.hasNextInt())
                {
                    int n=scanner.nextInt();
                    if(keys.contains(n))
                    {
                        s=s+map.get(n)+" ";
                    }
                    else s=s+String.valueOf(n)+" ";
                }
                else s=s+scanner.next()+" ";
            }
            scanner.close();
            s=s.trim()+"\n";
        }
        System.out.print(s);
        fileScanner.close();

    }
}
