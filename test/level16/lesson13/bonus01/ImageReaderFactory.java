package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by nickame on 20.09.15.
 */
public class ImageReaderFactory
{
    public static synchronized ImageReader getReader(ImageTypes imageTypes)
    {

           if (imageTypes==ImageTypes.BMP)
               return new BmpReader();
           else

           if(imageTypes==ImageTypes.JPG)
               return new JpgReader();
           else
           if (imageTypes==ImageTypes.PNG)
               return new PngReader();
           else throw  new IllegalArgumentException("Неизвестный тип картинки");
         
    }
}
