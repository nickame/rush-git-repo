package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/



import java.io.*;


public class FileConsoleWriter extends FileWriter
{
         public FileConsoleWriter(String fileName) throws IOException {
            super(fileName);
        }

        public FileConsoleWriter(String fileName, boolean append) throws IOException {
            super(fileName, append);
        }

        public FileConsoleWriter(File file) throws IOException {
            super(file);
        }

        public FileConsoleWriter(File file, boolean append) throws IOException {
            super(file, append);
        }

        public FileConsoleWriter(FileDescriptor fd) {
            super(fd);
        }

    public void write(int c) throws IOException
    {
        char[] ch = {(char)c};
        write(ch,0,1);


    }

    public void write(char[] cbuff) throws IOException
    {
        write(cbuff,0,cbuff.length);


    }
    public void write(char[] cbuff, int i, int j) throws IOException
    {
        super.write(cbuff, i, j);
        System.out.print(String.valueOf(cbuff,i,j));


    }
    public void write(String str) throws IOException
    {
        write(str.toCharArray(),0,str.length());

    }
    public void write(String str, int i, int j) throws IOException
    {
        write(str.toCharArray(), i, j);

    }

}

