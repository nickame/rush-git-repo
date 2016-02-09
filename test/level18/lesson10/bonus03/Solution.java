package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));

        ArrayList<String> lines = new ArrayList<>();
        while (fileIn.ready())
            lines.add(fileIn.readLine());
        int id = 0, idmax = Integer.parseInt(args[1]);
        for (int i = 0; i < lines.size(); i++)
        {
            id = Integer.parseInt(lines.get(i).substring(0, 8).trim());
            if ((idmax == id) & (args[0].equals("-u")))
            {
                String finstr = "";
                String finid = String.valueOf(id);
                String finproductName = args[2];
                if (args.length>5)
                for (int j = 3; j < args.length - 2; j++)
                    finproductName = finproductName + " " + args[j];
                String finprice = args[args.length - 2];
                String finquantity = args[args.length - 1];

                finstr = finstr.format("%-8s%-30s%-8s%-4s", finid, finproductName, finprice, finquantity);
                lines.set(i, finstr);
            } else if ((idmax == id) & (args[0].equals("-d")))
                lines.remove(i);

        }

        fileIn.close();

        FileWriter writer = new FileWriter(fileName);

        for (String lined : lines)

            writer.write(lined + '\n');

        writer.close();
    }


}
