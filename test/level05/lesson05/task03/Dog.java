package com.javarush.test.level05.lesson05.task03;

/* Геттеры и сеттеры для класса Dog
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
*/

public class Dog
{
    private String name;
    private int age;//добавьте переменные класса тут

    public void setName(String name)
    {
        this.name = name;//добавьте геттеры и сеттеры тут
    }

    public void setAge(int age)
    {
        this.age = age;//добавьте геттеры и сеттеры тут
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
}

