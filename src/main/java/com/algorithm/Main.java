package com.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scoreArray = new int[N];

        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int score = sc.nextInt();
            if (score > max) {
                max = score;
            }
            sum += score;
            scoreArray[i] = score;
        }
        System.out.println(sum * 100.0 / max / N);

    }
}
// 80

// 40/80*100
// 60/80*100
// 80/80*100