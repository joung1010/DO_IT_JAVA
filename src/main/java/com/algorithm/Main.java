package com.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] intArr;
    public static int[] tmpArr;

    public static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        intArr = new int[totalCount];
        tmpArr = new int[totalCount];
        for (int i = 0; i < totalCount; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, totalCount - 1);
        System.out.println(count);
    }

    public static void mergeSort(int s, int e) {
        if (e - s < 1) {
            return;
        }

        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmpArr[i] = intArr[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m
                && idx2 <= e) {

            if (tmpArr[idx1] > tmpArr[idx2]) {
                intArr[k] = tmpArr[idx2];
                count += (m - idx1 + 1); // 왼쪽 부분 배열에서 남은 요소의 수를 더합니다.
                idx2++;
            } else {
                intArr[k] = tmpArr[idx1];
                idx1++;
            }
            k++;
        }

        while (idx1 <= m) {
            intArr[k++] = tmpArr[idx1++];
        }
        while (idx2 <= e) {
            intArr[k++] = tmpArr[idx2++];
        }
    }
}
