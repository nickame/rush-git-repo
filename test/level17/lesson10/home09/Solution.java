package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        try
        {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String  first=reader.readLine();
            String second=reader.readLine();

        BufferedReader readerall = new BufferedReader(new FileReader(first));
        BufferedReader readerforr = new BufferedReader(new FileReader(second));
        String line;
        while ((line = readerall.readLine()) != null)
        {
            allLines.add(line);
        }
       // System.out.println(allLines);
        while ((line = readerforr.readLine()) != null)
        {
            forRemoveLines.add(line);
        }
      //  System.out.println(forRemoveLines);
        readerall.close();
        readerforr.close();


           new Solution().joinData();
        }
        catch (CorruptedDataException e)
        {
            System.out.print("как-то так");
        }
        catch (Exception z)
        {
            System.out.println("остальные косяки");
        }
       // System.out.println(allLines);



    }

    public  void joinData() throws CorruptedDataException
    {
       /* int count = 0;

            for (int j = 0; j < forRemoveLines.size(); j++)
            {
                if (allLines.contains(forRemoveLines.get(j)))
                {
                   // allLines.remove(i);
                    count += 1;
                }
            }

        if (count == 0)
        {
            allLines.clear();
            throw new CorruptedDataException();
        }*/

       if(allLines.containsAll(forRemoveLines))
       {
           allLines.removeAll(forRemoveLines);
       }
        else
       {
           allLines.clear();
        throw new  CorruptedDataException();
       }
    }
}
