package com.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static String solution(int[] numbers) {

        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] % 10 > numbers[minIdx] % 10) {
                    minIdx = j;
                }
            }
            int tmp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = tmp;

        }
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String solution = solution(new int[]{6, 10, 2});
        System.out.println("solution = " + solution);
    }
}
