package com.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long res = 0L;

        long[] sumArr = new long[N];
        sumArr[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        long[] remainCntArr = new long[M];
        for (int i = 0; i < N; i++) {
            int remain = (int) (sumArr[i] % M);

            if (remain == 0) res++;

            remainCntArr[remain]++;
        }

        for (int i = 0; i < M; i++) {
            if (remainCntArr[i] > 1) {
                res += (remainCntArr[i] * (remainCntArr[i] - 1)) / 2;
            }
        }
        System.out.println(res);

    }
}
