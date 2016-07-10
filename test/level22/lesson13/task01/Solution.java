package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
//    public static void main(String[] args){
//       String[] s = getTokens("level22.lesson13.task01", ".");
//        for (String t : s)
//        {System.out.println(t);}
//    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stk = new StringTokenizer(query,delimiter);
        int count = stk.countTokens();
        String[] rezult= new String[count];
        for(int i=0; i<count; i++ )
            rezult[i]=stk.nextToken();
        return rezult;
    }
}
