package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public static void main(String[] args)
    {
        Solution someProp = new Solution();
        someProp.fillInPropertiesMap();
        System.out.println(properties);
    }


    public void fillInPropertiesMap() {
       try
       {
           Scanner scanner = new Scanner(System.in);
           File file = new File(scanner.nextLine());
           InputStream inputStream = new FileInputStream(file);
           load(inputStream);
           scanner.close();
           //implement this method - реализуйте этот метод
       }
       catch (IOException e){System.out.println("some shit with file\\/n"+e);}
       catch (Exception e)
       {
           e.printStackTrace();
       }

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties p = new Properties();
        for(Map.Entry<String, String> entry : properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            p.setProperty(key, value);
        }
        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties p = new Properties();
        p.load(inputStream);
        Enumeration e = p.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = p.getProperty(key);
            properties.put(key, value);
        }
    }
}
