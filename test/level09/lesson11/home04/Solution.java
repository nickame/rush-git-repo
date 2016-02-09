package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        Date date = format.parse(reader.readLine()); //напишите тут ваш код


        SimpleDateFormat format1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println((format1.format(date).toUpperCase()));
    }

//    private DateFormatSymbols myne = new DateFormatSymbols();
//
//
//    public String[] getMonths()
//    {
//        return new String[]{"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DESEMBER"};
//    }
//

             }
