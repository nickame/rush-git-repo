package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10;i++)
        {
            list.add(Integer.parseInt(reader.readLine()));
        } //Напишите тут ваш код  //Напишите тут ваш код

        for(int i=0; i<list.size();i++)
          System.out.println(list.get(list.size()-1-i)); //Напишите тут ваш код
    }
}
