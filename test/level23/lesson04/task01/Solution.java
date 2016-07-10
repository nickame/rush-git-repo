package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] sol = new Solution[2];
        for(int i = 0; i< sol.length; i++)
        {
            sol[i]=new Solution();
            sol[i].innerClasses[0]=sol[i].new InnerClass();
            sol[i].innerClasses[1]=sol[i].new InnerClass();
        }
        return sol;
    }
}
