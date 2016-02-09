package com.javarush.test.level22.lesson09.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner fscanner = new Scanner(new File(scanner.nextLine()));
        String s=null;
        while (fscanner.hasNextLine()){
            s=s+" "+fscanner.nextLine();
        }
        scanner.close();
        fscanner.close();
        if (s!=null)
        {
            String[] str = s.split(" ");
            for (int i = 0; i < str.length; i++)
                for (int j = i + 1; j < str.length; j++)
                {
                    String s2 = new StringBuilder(str[j]).reverse().toString();
                    if (str[i].equals(s2))
                    {
                        Pair p = new Pair();
                        p.first = str[i];
                        p.second = str[j];
                        result.add(p);
                        str[i] = "";
                        str[j] = "";
                    }
                }
        }
//        for(int i=0;i<result.size();i++)
//            for(int j=i+1;j<result.size();j++)
//            {
//                if(((result.get(i).first.equals(result.get(j).first))||
//                (result.get(i).first.equals(result.get(j).second)))&
//                        ((result.get(i).second.equals(result.get(j).first))||
//                (result.get(i).second.equals(result.get(j).second))))
//                    result.remove(j);
//            }
        for (Pair p : result)
            System.out.println(p);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
