package com.javarush.test.level19.lesson10.home03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner fileScanner = new Scanner(new FileInputStream(args[0]));

        String line="";
        while (fileScanner.hasNextLine())
        {
            line=fileScanner.nextLine();
            String[] lines = line.split(" ");
            String name = lines[0];
            for (int i=1; i<lines.length-3;i++)
                name=name+" "+lines[i];
           PEOPLE.add(new Person(name, new GregorianCalendar(Integer.parseInt(lines[lines.length-1]),
                   Integer.parseInt(lines[lines.length-2])-1, Integer.parseInt(lines[lines.length-3])).getTime()));
        }

        fileScanner.close();
    }

}
