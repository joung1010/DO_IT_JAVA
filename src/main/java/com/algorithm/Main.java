package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static int[] chkCntArr = new int[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;

        int dnaCharLen = sc.nextInt();
        int passwordLen = sc.nextInt();
        String charStr = null;
        do {
            charStr = sc.nextLine();
        } while (charStr.length() != dnaCharLen);

        for (int i = 0; i < chkCntArr.length; i++) {
            chkCntArr[i] = sc.nextInt();
        }

        int[] currArr = new int[4];
        for (int i = 0; i < passwordLen; i++) {
            if("A".equals(charStr.charAt(i))) currArr[i]++;
            if("C".equals(charStr.charAt(i))) currArr[i]++;
            if("G".equals(charStr.charAt(i))) currArr[i]++;
            if("T".equals(charStr.charAt(i))) currArr[i]++;
        }
        if (isRightPassword(currArr)) {
            res++;
        }

        for (int i = passwordLen; i < dnaCharLen; i++) {

        }
    }

    private static boolean isRightPassword(int[] currArr) {
        return IntStream.range(0, chkCntArr.length)
                .allMatch(i -> currArr[i] >= chkCntArr[i]);
    }
}
