package com.algorithm;

import java.io.*;

public class Main {
    public static int[] intArr;
    public static int[] tmpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalNum = Integer.parseInt(br.readLine());
        intArr = new int[totalNum];
        tmpArr = new int[totalNum];

        for (int i = 0; i < totalNum; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, totalNum - 1);
        for (int i = 0; i < totalNum; i++) {
            bw.write(intArr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            tmpArr[i] = intArr[i];
        }

        int grpIdx1 = start;
        int grpIdx2 = mid + 1;
        int target = start;

        while (grpIdx1 <= mid && grpIdx2 <= end) {
            if (tmpArr[grpIdx1] <= tmpArr[grpIdx2]) {
                intArr[target++] = tmpArr[grpIdx1++];
            } else {
                intArr[target++] = tmpArr[grpIdx2++];
            }
        }

        while (grpIdx1 <= mid) {
            intArr[target++] = tmpArr[grpIdx1++];
        }

        while (grpIdx2 <= end) {
            intArr[target++] = tmpArr[grpIdx2++];
        }
    }
}
