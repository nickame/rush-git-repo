package com.javarush.test.level19.lesson03.task04;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution
{
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }


        @Override
        public Person read() throws IOException
        {

            String firstName;
            String middleName;
            String lastName;
            Calendar birthDate;
            String person[];
            if (scanner.hasNextLine())
            {
                person = scanner.nextLine().split(" ");
                lastName = person[0];
                firstName = person[1];
                middleName = person[2];
                birthDate=new GregorianCalendar(Integer.parseInt(person[5]), Integer.parseInt(person[4])-1, Integer.parseInt(person[3]));


                return new Person(firstName, middleName, lastName, birthDate.getTime());
            }
            else return null;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
