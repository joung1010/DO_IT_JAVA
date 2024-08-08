package com.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*
    * 6
610 , 106
62, 26

10
102, 210 102 > 210
maxIdx = 3


temp = 10
curr =  2
6 2 10
    *
    * */
    public static String solution(int[] numbers) {

        final int length = numbers.length;
        String[] numbersStrArr = new String[length];
        for (int i = 0; i < length; i++) {
            numbersStrArr[i] = String.valueOf(numbers[i]);
        }

        for (int i = 0; i < numbersStrArr.length; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < length; j++) {
                String strNum1 = numbersStrArr[j] + numbersStrArr[maxIdx];
                String strNum2 = numbersStrArr[maxIdx] + numbersStrArr[j];
                if (strNum1.compareTo(strNum2) > 0) {
                    maxIdx = j;
                }
            }
            String tmp = numbersStrArr[maxIdx];
            numbersStrArr[maxIdx] = numbersStrArr[i];
            numbersStrArr[i] = tmp;
        }

        if (numbersStrArr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String strNum : numbersStrArr) {
            result.append(strNum);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String solution = solution(new int[]{6, 10, 2});
        System.out.println("solution = " + solution);
    }
}
