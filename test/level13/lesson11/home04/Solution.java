package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String  str = reader.readLine();
        String path = str;
        str = reader.readLine();
        while (true)
        {
            if((str.equals("exit")))
            {
                list.add(str);
                break;
            }
            else
            {
                list.add(str);
                str = reader.readLine();
            }
        }

        File file = new File(path);
           /* if (!file.exists())
                file.createNewFile();*/

        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
        for(String s : list)

        {
            out.print(s+"\r\n");
        }
        reader.close();
      out.close();

    }
}
