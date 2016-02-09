package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1



    }

    public static void main(String[] args) throws ParseException
    {
      switch (args[0])
      {
          case "-c" : {create(args);break;}
          case "-u" : {update(args);break;}
          case "-i" : {info(args);break;}
          case "-d" : {delete(args);break;}
      }


//        String s;
//        String a[]= new String[2] ;
//        a[0]="0";
//       for (int i=0; i<allPeople.size();i++)
//       {
//           s=Integer.toString(i);
//           a[1]=s;
//           info(a);
//       }
//            //start here - начни тут
    }
    public synchronized static void create(String[] args) throws ParseException
    {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/y");
        Person p ;

        int i=1;
        while (i<args.length)
        {

            if (args[i + 1].equals("м"))
            {
                p = Person.createMale(args[i], simpleDateFormat.parse(args[i + 2]));
                allPeople.add(p);
            } else if (args[i+1].equals("ж"))
            {
                p = Person.createFemale(args[i], simpleDateFormat.parse(args[i + 2]));
                allPeople.add(p);
            }
            System.out.println(allPeople.size() - 1);
            i=i+3;
        }

    }
    public synchronized static void update(String[] args) throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/y");
        Person p ;

        for (int i=1; i<args.length; i=i+4)
        {
            p = allPeople.get(Integer.parseInt(args[i]));
            if (args[i+2].equals("м"))
            {
                p.setSex(Sex.MALE);
                p.setName(args[i+1]);
                p.setBirthDay(simpleDateFormat.parse(args[i+3]));
                allPeople.set(Integer.parseInt(args[i]), p);
            } else if (args[i+2].equals("ж"))
            {
                p.setSex(Sex.FEMALE);
                p.setName(args[i+1]);
                p.setBirthDay(simpleDateFormat.parse(args[i+3]));
                allPeople.set(Integer.parseInt(args[i]), p);
            }

        }

    }
    public synchronized static void info(String[] args)
    {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        Person p;

        for(int i=1; i<args.length; i++)
        {
            p = allPeople.get(Integer.parseInt(args[i]));
            System.out.println(p.getName() + " " + ((p.getSex().equals(Sex.MALE)) ? "м" : "ж") + " " + simpleDateFormat1.format(p.getBirthDay()));
        }

    }
    public synchronized static void delete(String[] args)
    {
        Person p;
        for(int i=1; i<args.length; i++)
        {
            p = allPeople.get(Integer.parseInt(args[i]));
            p.setName(null);
            p.setBirthDay(null);
            p.setSex(null);
            allPeople.set(Integer.parseInt(args[i]), p);
        }
    }
}
