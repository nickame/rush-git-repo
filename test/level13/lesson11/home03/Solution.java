package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));

            //В цикле построчно считываем файл
            String s;
            while ((s = in.readLine()) != null) {
               System.out.println(s);
            }

            in.close();
        reader.close();
        //add your code here
    }
}
