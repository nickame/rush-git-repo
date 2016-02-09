package com.javarush.test.level22.lesson05.task01;

import java.util.ArrayList;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
    String str=null;
    System.out.println(getPartOfString(str));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if(string==null) throw new TooShortStringException();
        String[] s = string.split("");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(string.indexOf(" ")+1);
        for(int i =list.get(0); i<s.length;i++ ){
            if(s[i].equals(" ")) list.add(i);
        }
        if (list.size()<5) throw new TooShortStringException();



        return string.substring(list.get(0),list.get(5)-1);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
