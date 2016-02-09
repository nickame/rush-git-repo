package com.javarush.test.level19.lesson10.bonus01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner file1Scanner = new Scanner(new FileInputStream(scanner.nextLine()));
        Scanner file2Scanner = new Scanner(new FileInputStream(scanner.nextLine()));
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        while (file1Scanner.hasNext())
            file1.add(file1Scanner.nextLine());
        while (file2Scanner.hasNextLine())
            file2.add(file2Scanner.nextLine());

        int i=0, j=0;
        while ((i<file1.size())&&( j < file2.size()))
        {
            if (file1.get(i).equals(file2.get(j)))
            {
                lines.add(new LineItem(Type.SAME,file1.get(i)));
            }

            else if ((j<file2.size()-1)&&(file1.get(i).equals(file2.get(j+1))))
            {
                lines.add(new LineItem(Type.ADDED, file2.get(j)));
                lines.add(new LineItem(Type.SAME,file2.get(j+1)));
                j++;
            }
            else if ((i<file1.size()-1)&&(file1.get(i+1).equals(file2.get(j))))
            {
                lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                lines.add(new LineItem(Type.SAME,file1.get(i+1)));
                i++;
            }

            i++; j++;
        }
       if(j<file2.size())
           lines.add(new LineItem(Type.ADDED , file2.get(j)));
        else if(i<file1.size())
           lines.add(new LineItem(Type.REMOVED , file1.get(i)));

        scanner.close();
        file1Scanner.close();
        file2Scanner.close();
//       for (LineItem l : lines)
//            System.out.println(l.type + "----" + l.line);
    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
