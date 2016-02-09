package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name, pol;
    private int age;

    public void initialize(String name)
    {
        this.name=name;
    }//Напишите тут ваш код
    public void initialize(String name, int age)
    {
        this.name=name;
        this.age=age;
    }//Напишите тут ваш код

    public void initialize(String name, int age, String pol)
    {
        this.name=name;
        this.age=age;
        this.pol=pol;
    }//Напишите тут ваш код//Напишите тут ваш код

}
