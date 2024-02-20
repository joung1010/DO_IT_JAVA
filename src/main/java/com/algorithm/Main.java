package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] uniqueNum = new int[N];
        for (int i = 0; i < N; i++) {
            uniqueNum[i] = sc.nextInt();
        }
        Arrays.sort(uniqueNum);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int strIdx = 0;
            int endIdx = N - 1;
            int target = uniqueNum[i];
            while (strIdx < endIdx) {
                if (uniqueNum[strIdx] + uniqueNum[endIdx] == target) {
                    if (strIdx != i && endIdx != i) {
                        cnt++;
                        break;
                    } else if (strIdx == i) {
                        strIdx++;
                    } else if (endIdx == i) {
                        endIdx--;
                    }
                } else if (uniqueNum[strIdx] + uniqueNum[endIdx] < target) {
                    strIdx++;
                } else {
                    endIdx--;
                }
            }
        }
        System.out.println(cnt);

    }
}
