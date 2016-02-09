package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        int age;
        float    height;
        double   weight;
        String name, surname, adress;
        Boolean sex;

        public Human(String name){}
        public Human(String name, String surname){}
        public Human(String name, String surname, String adress){}
        public Human(Boolean sex){}
        public Human(int age){}
        public Human(float height){}
        public Human(double weight){}
        public Human(String name, Boolean sex){}
        public Human(String surname, int age){}
        public Human(String name, String surname, String adress, int age){}

        //напишите тут ваши переменные и конструкторы
    }
}
