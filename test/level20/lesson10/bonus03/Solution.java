package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        for (Word w : detectAllWords(crossword, "home", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop",
                "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "o"))
            System.out.println(w);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        List<Word> word = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
        {
            char[] s = words[i].toCharArray();
            List<A> listA = new ArrayList<>();
            List<B> listB = new ArrayList<>();
            for (int x = 0; x < crossword.length; x++)
            {
                for (int y = 0; y < crossword[x].length; y++)
                {
                    if (s[0] == crossword[x][y]) listA.add(new A(x, y));
                    if (s[s.length - 1] == crossword[x][y]) listB.add(new B(x, y));
                }
            }

            for (int k = 0; k < listA.size(); k++)
            {
                for (int t = 0; t < listB.size(); t++)
                {
                    int dx = listB.get(t).x - listA.get(k).x;
                    int dy = listB.get(t).y - listA.get(k).y;
                    int ks = s.length - 1;
                    if(ks==0)ks=1;
                    if ((dx % ks == 0) & (dy % ks == 0) & (Math.abs(dx / ks) < 2) & (Math.abs(dy / ks) < 2))
                    {
                        int vektrX = dx / ks;
                        int vektrY = dy / ks;
                        boolean flag = true;
                        int z = 0;
                        int x = listA.get(k).x;
                        int y = listA.get(k).y;
                        while (z<s.length)
                        {
                            //(x == listB.get(t).x) & (y == listB.get(t).y)
                            if (s[z] == (char) crossword[x][y])
                            {
                                z++;
                            } else
                            {
                                flag = false;
                                z++;
                            }
                            x = x + vektrX;
                            y = y + vektrY;
                        }

                        if (flag)
                        {
                            Word w = new Word(words[i]);
                            w.setStartPoint(listA.get(k).y, listA.get(k).x);
                            w.setEndPoint(listB.get(t).y, listB.get(t).x);
                            word.add(w);

                        }
                    }
                }
            }
        }

        return word;
    }

    public static class A
    {
        int x, y;

        public A(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static class B
    {
        int x, y;

        public B(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
