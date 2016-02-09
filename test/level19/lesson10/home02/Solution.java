package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner fileScanner = new Scanner(new FileInputStream(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        Double max=0.0;
        while (fileScanner.hasNext())
        {
            String[] str = fileScanner.nextLine().split(" ");
            if (map.containsKey(str[0])) map.put(str[0], (map.get(str[0])+Double.parseDouble(str[1])));
            else
            {
                map.put(str[0], Double.parseDouble(str[1]));
                max=Double.parseDouble(str[1]);
            }
        }

        for(String key : map.keySet())
            if (map.get(key)> max) max=map.get(key);
        for(String key : map.keySet())
            if (map.get(key).equals(max))
                 System.out.println(key);

        fileScanner.close();
    }
}
