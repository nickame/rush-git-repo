package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String tag = args[0];
        String tagStart = "<" + tag, tagEnd = "</" + tag + ">", midTag="<"+tag+">";

        Pattern p = Pattern.compile(tagEnd);
        Scanner scanner = new Scanner(System.in);
        Scanner filescanner = new Scanner(new File(scanner.nextLine())).useDelimiter(p);
        while (filescanner.hasNext())
        {
            String str=filescanner.next();
            int ind=str.indexOf(tagStart);
            if(ind>-1)
            if((str.indexOf(tagStart,ind+1)== -1))
            {
                System.out.println((str.substring(ind,str.length())+tagEnd).replaceAll("\\s+", " "));
            }
            else
            {
                str=str.substring(ind,str.length())+tagEnd;
               // ind = str.indexOf(tagStart, ind );
                do
                {
                    str = str + filescanner.next()+tagEnd;
                    ind = str.indexOf(tagStart, ind+1 );
                }
                while ((str.indexOf(tagStart, ind+1 ) > -1)&&(str.indexOf(tagStart, ind+1 )<str.indexOf(tagEnd)));
                str=str.replaceAll("\\s+", " ");
                System.out.println(str);
                ind=str.indexOf(tagStart,1);
                int ind2=str.lastIndexOf(tagEnd,str.length()-tagEnd.length()-1);
                while (ind>-1)
                {

                    System.out.println((str.substring(ind,ind2+tagEnd.length()).replaceAll("\\s+", " ")));
                    ind=str.indexOf(tagStart,ind+1);
                    ind2=str.lastIndexOf(tagEnd,ind2-1);
                }

            }
        }
    }
}
