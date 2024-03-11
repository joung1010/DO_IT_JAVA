package com.algorithm;


import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }
        int[] resArr = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && numArr[stack.peek()] < numArr[i]) {
                resArr[stack.pop()] = numArr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            resArr[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.append(resArr[i] + " ");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}


