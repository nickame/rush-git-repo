package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String path = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            path = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String sst = read(path);
        int[] arr = toIntArray(sst);
        int[] result = sort(arr);
        for (int rez : result)
        {
            System.out.println(rez);
        }

        // напишите тут ваш код
    }

    public static int[] sort(int[] arr)
    {
        int count = 0;
        for (int i : arr)
            if (i % 2 == 0)
                count++;
        int[] result = new int[count];
        int k = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i]%2==0)
            {
                result[k]=arr[i];
                k++;
            }
        }
        for(int i=0; i<result.length; i++)
            for(int j=i; j<result.length;j++)
                if (result[i]>result[j])
                {int c = result[i];
                    result[i]=result[j];
                    result[j]=c;
                }


            return result;
    }


    public static String read(String fileName) throws FileNotFoundException
    {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);
        File file = new File(fileName);

        try
        {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try
            {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null)
                {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            finally
            {
                //Также не забываем закрыть файл
                in.close();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    private static void exists(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        if (!file.exists())
        {
            throw new FileNotFoundException(file.getName());
        }
    }

    private static int[] toIntArray(String s)
    {
        String[] str = s.split("\n");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++)
        {
            arr[i] = Integer.parseInt(str[i]);
        }

        return arr;
    }
}
