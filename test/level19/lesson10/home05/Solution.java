package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner fileScanner = new Scanner(new FileInputStream(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        String str, finsrt = "";
        while (fileScanner.hasNextLine())
        {
            str = fileScanner.nextLine();
            String[] s = str.split(" ");
            for(String s1 : s )
            {
                char[] ch=s1.toCharArray();
                for(Character ch1 : ch)
                {
                    if(ch1.isDigit(ch1))
                    {
                        finsrt=finsrt + s1+" ";
                        break;
                    }
                }
            }
        }
        finsrt=finsrt.trim();
        fileWriter.write(finsrt);
        fileScanner.close();
        fileWriter.close();
    }
}
