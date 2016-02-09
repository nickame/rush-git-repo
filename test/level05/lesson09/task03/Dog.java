package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name, pol;
    private int age;

    public Dog(String name)
    {
        this.name = name;
    }//Напишите тут ваш код

    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }//Напишите тут ваш код

    public Dog(String name, int age, String pol)
    {
        this.name = name;
        this.age = age;
        this.pol = pol;
    }//Напишите тут ваш код//Напишите тут ваш ко//Напишите тут ваш код

}
