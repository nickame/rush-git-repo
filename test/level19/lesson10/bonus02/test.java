package com.javarush.test.level19.lesson10.bonus02;

import java.io.IOException;

/**
 * Created by Nick on 02.01.2016.
 */
public class test
{
    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter writer = new FileConsoleWriter("d:\\test.txt");
        char[] ch = new char[26];
        for (int i=0; i<26; i++)
        {
            ch[i]=(char)('a'+i);
        }
        char tmp[] = {'a','b','c'};
        writer.write(tmp,1,2);
        writer.write(tmp);
        writer.write(116);
        writer.write("mother",2,2);
        writer.write("mother");
        writer.write(100);
        writer.write(ch,0,5);
        writer.write("uuuuuuuuuuuuuuuu",1,3);
        writer.close();
    }
}
