package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        if (args[0].equals("-c"))
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            String str;
            byte[] buff = new byte[fileIn.available()];
            fileIn.read(buff);
            char[] chbuff = new char[buff.length];
            for (int i = 0; i < buff.length; i++)
                chbuff[i] = (char) buff[i];
            str = String.valueOf(chbuff);
            String[] lines = str.split("\n");

            int id = 0, idmax = id;
            for (String line : lines)
            {
                id = Integer.parseInt(line.substring(0, 8).trim());
                if (idmax < id) idmax = id;
            }
            String finstr = "";
            String finid = String.valueOf(idmax + 1);
            String finproductName = args[1];
            for (int i = 2; i < args.length - 2; i++)
                finproductName = finproductName + " " + args[i];
            String finprice = args[args.length - 2];
            String finquantity = args[args.length - 1];

            finstr = finstr.format("%-8s%-30s%-8s%-4s", finid, finproductName, finprice, finquantity);

            fileIn.close();

            FileWriter writer=new FileWriter(fileName, true);
            writer.write(finstr);
            writer.close();


       }


    }
}
