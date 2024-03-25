package com.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] numberArray = new int[N];
        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(bf.readLine());
        }

        int result = 0;
        for (int i = 1; i < numberArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numberArray[j] < numberArray[j - 1]) {
                    // 두 요소를 교환
                    int temp = numberArray[j];
                    numberArray[j] = numberArray[j - 1];
                    numberArray[j - 1] = temp;

                    result++;
                } else {
                    // 이미 작은 수가 앞에 있으므로 더 이상 확인할 필요 없음
                    break;
                }
            }
        }

        System.out.println(result);

    }
}



