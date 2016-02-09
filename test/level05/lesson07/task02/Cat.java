package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,*******
- Имя, вес, возраст*****************
- Имя, возраст (вес стандартный)***********
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)***********
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name, adres, color;
    private int age, weight;

    public void initialize(String name)
    {
        this.name=name;
    }//Напишите тут ваш код
    public void initialize(String name, int age)
    {
        this.name=name;
        this.age=age;
        this.weight=3;
    }//Напишите тут ваш код

    public void initialize(String name, int weight, int age)
    {
        this.name=name;
        this.age=age;
        this.weight=weight;
    }//Напишите тут ваш код
    public void initialize(int weight, String color)
    {
        this.color=color;
        this.weight=weight;
        this.name=null;
        this.age=2;
        this.adres=null;
    }//Напишите тут ваш код//Напишите тут ваш код
    public void initialize(int weight, String color, String adres)
    {
        this.color=color;
        this.weight=weight;
        this.name=null;
        this.age=2;
        this.adres=adres;
    }//Напишите тут ваш код//Напишите тут ваш код
}
