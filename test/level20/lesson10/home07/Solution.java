package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String filename;
    private static final long serialVersionUID=1L;
    public static void main(String args[]) throws IOException, ClassNotFoundException
    {

        FileOutputStream fileOutput = new FileOutputStream("/home/nickame/file.tmp");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        Solution solution;
        solution = new Solution("/home/nickame/2.ser");
        outputStream.writeObject(solution);

        solution=new Solution("/home/nickame/3.ser");
        outputStream.writeObject(solution);

        FileInputStream fiStream = new FileInputStream("/home/nickame/file.tmp");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        System.out.println((Solution)objectStream.readObject());
        System.out.println((Solution)objectStream.readObject());

    }
    public Solution()
    {


    }

    public Solution(String fileName) throws FileNotFoundException {
        this.filename=fileName;
        this.stream = new FileOutputStream(fileName,true);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream=new FileOutputStream(this.filename,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
       // stream.close();
    }
}
