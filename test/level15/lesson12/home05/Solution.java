package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
   private Solution(double k){}
   private Solution(Double k){}
   private Solution(char k){}

   public Solution(){}
   public Solution(int i){}
   public Solution(Integer i){}

   protected Solution(String s){}
   protected Solution(String s, int k){}
   protected Solution(String s, double k){}

   Solution(boolean k){}
   Solution(boolean k, boolean l){}
   Solution(boolean j, char g){}

}

