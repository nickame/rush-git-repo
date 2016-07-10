package com.javarush.test.level22.lesson13.task03;

import java.util.regex.*;


/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static void main(String[] args)
    {
        System.out.println("+380501234567 "+checkTelNumber("+380501234567"));
        System.out.println("(123)-456-7890  "+checkTelNumber("(123)-456-7890"));
        System.out.println("+38(050)123-4567 "+checkTelNumber("+38(050)123-4567"));
        System.out.println("+38050123-45-67 "+checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 "+checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 "+checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 "+checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 "+checkTelNumber("050ххх4567"));
        System.out.println("050123456 "+checkTelNumber("050123456"));
        System.out.println("(0)501234567 "+checkTelNumber("(0)501234567"));



    }

    public static boolean checkTelNumber(String telNumber) {
        switch (telNumber.charAt(0)){
            case '+':{return plusStarted(telNumber);}
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '(':{return otherStarted(telNumber);}
            default:return false;

        }
    }
    public static boolean plusStarted(String telNumber){
        if(telNumber.length()<13 || telNumber.length()>17 || telNumber.replaceAll("\\D","").length()!=12) return  false;
            Pattern pattern = Pattern.compile("\\d+");
            Pattern pattern1 = Pattern.compile("\\d+[(]{1}\\d{3}[)]{1}\\d+-?\\d+-?\\d+");
            Pattern pattern2 = Pattern.compile("\\d+-?\\d+-?\\d+");
            Matcher matcher = pattern.matcher(telNumber.substring(1));
            Matcher matcher1 = pattern1.matcher(telNumber.substring(1));
            Matcher matcher2 = pattern2.matcher(telNumber.substring(1));
            if(matcher.matches()) return matcher.matches();
            if(matcher1.matches()) return matcher1.matches();
            if(matcher2.matches()) return matcher2.matches();
            return false;
        }

    public static boolean otherStarted(String telNumber)
    {
        if (telNumber.length() < 10 || telNumber.length() > 14 || telNumber.replaceAll("\\D","").length()!=10) return false;
        Pattern pattern = Pattern.compile("\\d+");
        Pattern pattern1 = Pattern.compile("\\d*[(]{1}\\d{3}[)]{1}\\d*-?\\d+-?\\d+");
        Pattern pattern2 = Pattern.compile("\\d+-?\\d+-?\\d+");
        Matcher matcher = pattern.matcher(telNumber);
        Matcher matcher1 = pattern1.matcher(telNumber);
        Matcher matcher2 = pattern2.matcher(telNumber);
        if (matcher.matches()) return matcher.matches();
        if (matcher1.matches()) return matcher1.matches();
        if (matcher2.matches()) return matcher2.matches();
        return false;
    }
}
