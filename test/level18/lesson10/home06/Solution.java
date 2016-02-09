package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buff = new byte[file.available()];
        file.read(buff);
        char[] chars = new char[buff.length];
        for (int i = 0; i < buff.length; i++)
        {
            chars[i] = (char) buff[i];
        }

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : chars)
        {
            map.put(c, 0);
        }
        for (char c : chars)
        {
            for (Map.Entry<Character,Integer> entry : map.entrySet())
            {
                if (c==entry.getKey())
                {
                    entry.setValue(entry.getValue()+1);
                }
            }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() +" "+entry.getValue());
        }

        file.close();
    }

}
