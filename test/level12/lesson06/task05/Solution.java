package com.javarush.test.level12.lesson06.task05;

/* Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static abstract class Pet
    {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet
    {
        private  String name;
        private Cat cat;
        public String getName()
        {
            return name;
        }
        public Pet getChild()
        {
            return cat;
        }
    }

    public static class Dog extends Pet
    {
        private  String name;
        private Dog dog;
        public String getName()
        {
            return name;
        }
        public Pet getChild()
        {
            return dog;
        }

    }

}
