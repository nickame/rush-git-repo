package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName=args[1];
        String fileOuPutName = args[2];
        FileInputStream fileIn = new FileInputStream(fileName);
        FileOutputStream fileOut = new FileOutputStream(fileOuPutName);
        if (args[0].equals("-e"))
        {
           while (fileIn.available()>0)
            fileOut.write(fileIn.read()+1);

        }
        else if(args[0].equals("-d"))
        {
            while (fileIn.available()>0)
                fileOut.write(fileIn.read()-1);
        }

        fileIn.close();
        fileOut.close();

    }

}
