package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int left, top, width, height;

    public void initialize(int left, int top, int width, int height)//Напишите тут ваш код
    {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }


    public void initialize(int left, int top)//Напишите тут ваш код
    {
        this.left = left;
        this.top = top;
        this.width = 0;
        this.height = 0;
    }

    public void initialize(int left, int top, int height)//Напишите тут ваш код
    {
        this.left = left;
        this.top = top;
        this.width = height;
        this.height = height;
    }


    public void initialize(Rectangle anotherRectangle)//Напишите тут ваш код
    {
        this.left = anotherRectangle.left;
        this.top = anotherRectangle.top;
        this.width = anotherRectangle.width;
        this.height = anotherRectangle.height;
    }
}
