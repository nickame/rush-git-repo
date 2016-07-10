package com.javarush.test.level22.lesson13.task02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        FileInputStream fin = new FileInputStream(new File(args[0]));
        FileOutputStream fot = new FileOutputStream(new File(args[1]));
        Charset utf8 = Charset.forName("UTF8");
        Charset windows1251 = Charset.forName("Windows-1251");
        byte[] buffer = new byte[fin.available()];
        fin.read(buffer);
        String s = new String(buffer, utf8);
        buffer = s.getBytes(windows1251);
        fot.write(buffer);
        fot.flush();
        fin.close();
        fot.close();
    }
}
