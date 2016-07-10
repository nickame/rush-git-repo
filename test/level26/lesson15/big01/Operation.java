package com.javarush.test.level26.lesson15.big01;

/**
 * Created by nickame on 11.04.16.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i){
     switch (i){

         case 1 : return INFO;
         case 2 : return DEPOSIT;
         case 3 : return WITHDRAW;
         case 4 : return EXIT;
         case 0 : throw new IllegalArgumentException();
         default: throw new IllegalArgumentException();
     }


    }
}
