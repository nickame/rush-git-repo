package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
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
    }//Напишите тут ваш код

}
