package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/y");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-y",Locale.ENGLISH);
        Person p ;

        if( args[0].equals("-c"))
        {

            if (args[2].equals("м"))
            {
                p = Person.createMale(args[1], simpleDateFormat.parse(args[3]));
                allPeople.add(p);
            }
            else if(args[2].equals("ж"))
            {
                p =  Person.createFemale(args[1], simpleDateFormat.parse(args[3]));
                allPeople.add(p);
            }
            System.out.println(allPeople.size()-1);

        }
        else if(args[0].equals("-u"))
        {

            p = allPeople.get(Integer.parseInt(args[1]));
            if(args[3].equals("м"))
            {
                p.setSex(Sex.MALE);
                p.setName(args[2]);
                p.setBirthDay(simpleDateFormat.parse(args[4]));
                allPeople.set(Integer.parseInt(args[1]),p);
            }
            else if(args[3].equals("ж"))
            {
                p.setSex(Sex.FEMALE);
                p.setName(args[2]);
                p.setBirthDay(simpleDateFormat.parse(args[4]));
                allPeople.set(Integer.parseInt(args[1]),p);
            }

        }
        else if(args[0].equals("-d"))
        {
            p=allPeople.get(Integer.parseInt(args[1]));
            p.setName(null);
            p.setBirthDay(null);
            p.setSex(null);
            allPeople.set(Integer.parseInt(args[1]),p);

        }
        else if(args[0].equals("-i"))
        {
            p= allPeople.get(Integer.parseInt(args[1]));
            System.out.println(p.getName()+" "+((p.getSex().equals(Sex.MALE))?"м":"ж")+" "+ simpleDateFormat1.format(p.getBirthDay()));
        }


    }
}
