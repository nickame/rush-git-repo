package com.javarush.test.level12.lesson09.task05;

/* Класс Human и интерфейсы Run, Swim
Напиши public класс Human(человек) и  public интерфейсы Run(бежать/ездить), Swim(плавать).
Добавь в каждый интерфейс по одному методу.
Добавь эти интерфейсы классу Human, но не реализуй методы.
Объяви класс Human абстрактным.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Run
    {
         public int speed();
    }
    public  interface Swim
    {
        public String style();
    }


    public abstract class Human implements Run, Swim
    {


    }
    //add public interfaces and public class here - добавь public интерфейсы и public класс тут
}