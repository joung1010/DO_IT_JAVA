package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] uniqueNum = new int[N];
        for (int i = 0; i < N; i++) {
            uniqueNum[i] = sc.nextInt();
        }
        Arrays.sort(uniqueNum);

        int strIdx = 0;
        int endIdx = N - 1;
        int count = 0;

        while (strIdx < endIdx) {
            if (uniqueNum[strIdx] + uniqueNum[endIdx] == M) {
                strIdx++;
                endIdx--;
                count++;
            } else if (uniqueNum[strIdx] + uniqueNum[endIdx] > M) {
                endIdx--;
            } else {
                strIdx++;
            }
        }
        System.out.println(count);
    }
}
