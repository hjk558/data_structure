package com.suanfa.demo_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ChainTest {

    public static void main(String[] args) {
        try {
            String midSuffix = "(8+9)-3+5/4+3*4";//
            ChainTest chainTest = new ChainTest();

            List<String> strings = chainTest.parseSuffixExpression(midSuffix);
            chainTest.computeSuffixExpression(strings);
            String st = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 四则运算
     * 中缀表达式转为后缀表达式
     */
    public List<String> parseSuffixExpression(String oper) {
        Stack<String> stack = new Stack<>();
        LinkedList<String> list = new LinkedList<>();
        String[] split = oper.split("");
        for (String s : split) {
            if (s.matches("\\d+") ){
                list.add(s);
            } else if (s.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        list.add(stack.pop());
                    }
                    stack.pop();
            } else if (stack.size() == 0
                        || ("(").equals(s)
                        ||("(").equals(stack.peek())
                        || getLevelValue(stack.peek()) < getLevelValue(s)) {
                    stack.push(s);
            } else {
                    while (stack.size() != 0 && getLevelValue(stack.peek()) >= getLevelValue(s)) {
                        list.add(stack.pop());
                    }
                    stack.push(s);
            }
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public void computeSuffixExpression(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                double result = 0.0;
                double a = Double.parseDouble(stack.pop());
                double b  = Double.parseDouble(stack.pop());
                switch (s) {
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                        if (a == 0.0) {
                            System.out.println("不能为0");
                        }
                        result = b / a;
                        break;
                     default:
                         System.out.println("异常运算符");
                }
                stack.push(result + "");
            }
        }
        System.out.println("计算结果:"+stack.pop());
    }

    public int getLevelValue(String s) {
        int result;
        switch (s) {
            case "+":
               result = 1;
               break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
             default:
                 result = 0;
        }
        return result;
    }
}
