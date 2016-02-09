package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner fileScanner = new Scanner(new FileInputStream(args[0]));
        TreeMap <String, Double> map = new TreeMap<>();
        while (fileScanner.hasNext())
        {
            String[] str = fileScanner.nextLine().split(" ");
            if (map.containsKey(str[0])) map.put(str[0], (map.get(str[0])+Double.parseDouble(str[1])));
            else map.put(str[0],Double.parseDouble(str[1]));
        }
        for(String key : map.keySet())
            System.out.println(key+" "+map.get(key));

       fileScanner.close();
    }
}
