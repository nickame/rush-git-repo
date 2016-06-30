package com.javarush.test.level22.lesson09.task01;

import java.io.File;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)
    {
        StringBuilder s = new StringBuilder();
        try
        {
            Scanner scanner = new Scanner(System.in);
            Scanner filescaner = new Scanner(new File(scanner.nextLine()));
            if (filescaner.hasNextLine()) ;
            s.append(filescaner.nextLine());
            while (filescaner.hasNextLine())
            {
                String tmp = filescaner.nextLine();
                if (!tmp.isEmpty())
                    s.append(" ").append(tmp);
            }
            scanner.close();
            filescaner.close();
        }
        catch (Exception e)
        {
        }
        String tmp = s.toString();
        String[] str = tmp.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(str));
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {

                if (list.get(i).equals(new StringBuilder(list.get(j)).reverse().toString()))
                {
                    Pair p = new Pair();
                    p.first = list.get(i);
                    p.second = list.get(j);
                    result.add(p);
                    list.remove(j);
                    break;
                }
            }
        }

        if (result.size() > 0)
            for (Pair pair : result)
            {
                System.out.println(pair);
            }
    }


    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
