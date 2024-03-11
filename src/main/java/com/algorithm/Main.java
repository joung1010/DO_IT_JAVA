package com.algorithm;


import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxNum = sc.nextInt();
        int[] numArr = new int[maxNum];
        IntStream.range(0, maxNum)
                .forEach(i -> numArr[i] = sc.nextInt());

        Stack<Integer> stack = new Stack<>();
        StringBuilder printer = new StringBuilder();
        int standard = 1;
        boolean result = true;
        for (int curNum : numArr) {
            if (curNum >= standard) {
                while (curNum >= standard) {
                    stack.push(standard++);
                    printer.append("+\n");
                }
            }
            if (stack.isEmpty() || stack.peek() != curNum) {
                System.out.println("NO");
                result = false;
                break;
            }
            stack.pop();
            printer.append("-\n");
        }
        if (result) System.out.println(printer.toString());
    }
}


