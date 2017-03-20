package com.javarush.task.task34.task3404;

import java.util.*;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        String f = "";
        String startString = expression;
        if (expression.startsWith("sin"))
        {
            f = "sin";
        }
        else if (expression.startsWith("cos"))
        {
            f = "cos";
        }
        else if (expression.startsWith("tan"))
        {
            f = "tan";
        }

        startString = expression.substring(4, expression.length()-1);


        Map<Character, Integer> operation = new HashMap<>();
        operation.put('+', 2);
        operation.put('-', 2);
        operation.put('*', 3);
        operation.put('(', 1);
        operation.put('/', 3);
        operation.put('^', 3);

        List<Character> digits = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        Stack operands = new Stack();
        Stack operations = new Stack();

        char[] str = startString.toCharArray();

        for (int i = 0; i < str.length; i++)
        {
            if (digits.contains(str[i]))
            {
                operands.push(str[i]);
            }
            if (operation.containsKey(str[i]))
            {
                if (operations.isEmpty())
                {
                    operations.push(str[i]);
                } else
                {

                    if (str[i] == '(')
                    {
                        operations.push(str[i]);
                        continue;
                    }
                    s:
                    if (operation.get(operations.peek()) < operation.get(str[i]))
                    {
                        operations.push(str[i]);
                    } else
                    {
                        while (operations.size() > 0 && operation.get(operations.peek()) >= operation.get(str[i]))
                        {
                            operands.push(operations.pop());

                        }
                        operations.push(str[i]);
                        break s;
                    }
                }
            }
            if (str[i] == ')')
            {
                while (operation.get(operations.peek()) != 1)
                {
                    operands.push(operations.pop());
                }
                operations.pop();
                continue;
            }

        }
        if (!operations.isEmpty())
        {
            while (!operations.isEmpty())
            {
                operands.push(operations.pop());
            }
        }

        Stack result = new Stack();
        double n1;
        double n2;

        while (!operands.isEmpty())
        {
            result.push(operands.pop());
        }

        while (!result.isEmpty())
        {
            if (digits.contains(result.peek()))
            {
                operations.push(Double.parseDouble(String.valueOf((Character) result.pop()))); //
            }

            if (operation.containsKey(result.peek()))
            {
                n1 = (double) operations.pop();
                n2 = (double) operations.pop();
                switch ((Character)result.peek())
                {
                    case '+' : operations.push(n2 + n1);
                        break;
                    case '-' : operations.push(n2 - n1);
                        break;
                    case '*' : operations.push(n2 * n1);
                        break;
                    case '/' : operations.push(n2 / n1);
                        break;
                    case '^' : operations.push((double) Math.pow(n2, n1));
                        break;
                }
                result.pop();

            }

        }

        double res = (double) operations.pop();

        switch (f)
        {
            case "sin" :
                System.out.println(Math.sin(res));
                break;
            case "cos" :
                System.out.println(Math.cos(res));
                break;
            case "tan" :
                System.out.println(Math.tan(res));
                break;
        }

    }

    public Solution() {
        //don't delete
    }
}
