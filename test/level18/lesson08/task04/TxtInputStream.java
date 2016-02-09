package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException
    {

        super(fileName);
        String ros;
        ros=fileName.substring(fileName.lastIndexOf("."));
        if(ros.equals(".txt"));
        else {throw new UnsupportedFileNameException();}
    }

//    public static void main(String[] args) throws FileNotFoundException, UnsupportedFileNameException
//    {   //  new TxtInputStream("/home/nickame/22.txt.zip");
//          new TxtInputStream("/home/nickame/1.txt");
//    }


}

