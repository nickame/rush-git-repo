package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children0 = new ArrayList<Human>();
        Human child1 = new Human("Tom",true,20,children0);
        Human child2 = new Human("Tomy",false,18,children0);
        Human child3 = new Human("Lee",true,16,children0);
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human father = new Human("Den",true,40,children);
        Human mother = new Human("Sam",false,36,children);
        ArrayList<Human> children1 = new ArrayList<Human>();
        children1.add(father);
        ArrayList<Human> children2 = new ArrayList<Human>();
        children2.add(mother);
        Human grandFather = new Human("Pit",true,63,children1);
        Human grandMother = new Human("Mari", false,60,children1);
        Human grandFather1 = new Human("Piter",true,65,children2);
        Human grandMother1 = new Human("Maria", false,63,children2);

       System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);



        //Написать тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children=new ArrayList<Human>();
        Human(String name,boolean sex, int age, ArrayList<Human> children)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children.addAll(children);
        }
        //Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
