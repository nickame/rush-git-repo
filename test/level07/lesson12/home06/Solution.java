package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Human HumanGrandFather = new Human(reader.readLine());
        Human HumanGrandMother = new Human(reader.readLine());
        Human HumanFather = new Human(reader.readLine(), HumanGrandFather, null);
        Human HumanMother = new Human(reader.readLine(), null, HumanGrandMother);
        Human HumanSon = new Human(reader.readLine(), HumanFather, HumanMother);
        Human HumanDaughter = new Human(reader.readLine(), HumanFather, HumanMother);

        System.out.println(HumanGrandFather);
        System.out.println(HumanGrandMother);
        System.out.println(HumanFather);
        System.out.println(HumanMother);
        System.out.println(HumanSon);
        System.out.println(HumanDaughter);  //Написать тут ваш код
    }

    public static class Human
    {
        private String name;
        private  Boolean sex;
        private int age;
        private Human father, mother;
        
        Human(String name)
        {
            this.name = name;
        }

        Human(String name, Human father, Human mother)
        {
            this.name = name;

            if (father.name!=null)

            {
                this.father.name = father.name;
            }

            if (mother.name!=null)

            {
                this.mother.name = mother.name;
            }

        }
        
        //Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
