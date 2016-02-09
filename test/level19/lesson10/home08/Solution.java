package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner =new Scanner(System.in);
        Scanner fileScanner= new Scanner(new FileInputStream(scanner.nextLine()));
        String str="";
        while (fileScanner.hasNext())
        {
            str=fileScanner.nextLine();
            StringBuffer s=new StringBuffer(str);
            System.out.println(s.reverse());

        }
        scanner.close();
        fileScanner.close();
    }
}
