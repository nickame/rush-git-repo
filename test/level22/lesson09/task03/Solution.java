package com.javarush.test.level22.lesson09.task03;

import java.io.File;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args)
    {
        String s = "";
        try
        {
            Scanner scanner = new Scanner(System.in);
            Scanner fscanner = new Scanner(new File(scanner.nextLine()));

            if (fscanner.hasNextLine())
            {
                s = fscanner.nextLine();

                while (fscanner.hasNextLine())
                {
                    String tmp = fscanner.nextLine();
                    if (!tmp.isEmpty())
                        s = s + " " + tmp;
                }
            }
            scanner.close();
            fscanner.close();
        }
        catch (Exception e)
        {
            System.out.println("somever bag");
        }


        //...
        StringBuilder result = getLine(s.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder resultStringBilder;
        boolean ischanged = false;

        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(" "))
            return new StringBuilder(words[0]);

            List<String> list = new ArrayList<>(Arrays.asList(words));

            resultStringBilder = new StringBuilder(list.get(0));
            for (int i = 1; i < list.size(); i++)
            {
                StringBuilder s1 = new StringBuilder(list.get(i).toLowerCase());

                if (resultStringBilder.toString().toLowerCase().charAt(resultStringBilder.length() - 1) == s1.charAt(0))
                {
                    resultStringBilder = resultStringBilder.append(" ").append(list.get(i));
                    list.remove(i);
                    ischanged = true;
                    i = 0;
                }
            }
            if ((list.size() > 1) && (ischanged))
            {
                list.add(resultStringBilder.toString());
                list.remove(0);
                resultStringBilder = getLine(list.toArray(new String[list.size()]));
            } else if ((list.size() > 1) && (!ischanged))
            {
                Collections.addAll(list, resultStringBilder.toString().split(" "));
                list.remove(0);
                resultStringBilder = getLine(list.toArray(new String[list.size()]));
            }
            return resultStringBilder;

    }
}
