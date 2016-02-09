package com.javarush.test.level18.lesson10.home08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!s.equals("exit"))
        {
            new ReadThread(s).run();
            s = scanner.nextLine();
        }
        scanner.close();
    }

    public static class ReadThread extends Thread
    {
        public ReadThread(String fileName) throws InterruptedException
        {

            this.fileName = fileName;
        }

        private String fileName;

        @Override
        public void run()
        {
            try
            {
                scanFile(fileName);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        private void scanFile(String fileName) throws IOException
        {
            FileInputStream file = new FileInputStream(fileName);
            Map<Integer, Integer> map = new HashMap<>();
            while (file.available() > 0)
            {
                int c = file.read();
                if (map.containsKey(c))
                {
                    for (Map.Entry<Integer, Integer> entry : map.entrySet())
                    {
                        if (c == entry.getKey())
                        {
                            entry.setValue(entry.getValue() + 1);
                        }
                    }
                } else map.put(c, 1);
            }
            int maxValue = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if (maxValue < entry.getValue())
                    maxValue = entry.getValue();
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if (maxValue == entry.getValue())
                {
                    resultMap.put(fileName, entry.getKey());
                }
            }
            file.close();
        }
    }
}
