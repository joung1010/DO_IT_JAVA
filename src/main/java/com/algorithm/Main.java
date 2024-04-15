package com.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalNum = Integer.parseInt(br.readLine());
        int[] intArr = new int[totalNum];
        for (int i = 0; i < totalNum; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(intArr, calculateMaxDigits(intArr));

        for (int value : intArr) {
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr, int maxDigits) {
        int place = 1;

        for (int digit = 0; digit < maxDigits; digit++) {
            int[] output = new int[arr.length];
            int[] count = new int[10];

            for (int num : arr) {
                count[(num / place) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int num = arr[i];
                int index = (num / place) % 10;
                output[count[index] - 1] = num;
                count[index]--;
            }

            System.arraycopy(output, 0, arr, 0, arr.length);
            place *= 10;
        }
    }

    private static int calculateMaxDigits(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return Integer.toString(max).length();
    }
}
