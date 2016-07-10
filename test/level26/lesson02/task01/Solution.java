package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {


    public static Integer[] sort(Integer[] array) {

        Arrays.sort(array);
        final double mediana;

        if(array.length%2==0) mediana=((double) (array[array.length / 2] + array[array.length / 2 - 1]))/2;
        else mediana=array[array.length/2];


        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return Math.abs(o1-(int)mediana)-Math.abs(o2-(int)mediana);
            }
        };
        Arrays.sort(array,comparator);
        return array;

    }
}
