package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("222222");
            user.setLastName("333333");
            user.setBirthDate(new Date(Integer.parseInt("123456468")));
            user.setMale(Boolean.parseBoolean("true"));
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            for (int i = 0; i < users.size(); i++)
            {
                printWriter.println(users.get(i).getFirstName());
                printWriter.println(users.get(i).getLastName());
                printWriter.println(users.get(i).getBirthDate());
                printWriter.println(users.get(i).isMale());
                printWriter.println(users.get(i).getCountry());
            }
            printWriter.close();

            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++)
            {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                DateFormat format = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy", Locale.ENGLISH);
                user.setBirthDate(format.parse(reader.readLine()));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                switch (reader.readLine())
                {
                    case "RUSSIA":
                    {
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    }
                    case "UKRAINE":
                    {
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    }
                    case "OTHER":
                    {
                        user.setCountry(User.Country.OTHER);
                        break;
                    }
                }

                users.add(user);
            }
            reader.close();

            //implement this method - реализуйте этот метод
        }
    }
}
