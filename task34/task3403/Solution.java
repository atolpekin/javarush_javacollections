package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        if (n <= 1) return;
       int x =2;
        while (n % x != 0)
        {
            x ++;
        }
        System.out.println(x);
        recursion(n / x);
    }


}
