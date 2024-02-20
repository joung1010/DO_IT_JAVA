package com.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static char[] DNA = {'A', 'C', 'G', 'T'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;

        int dnaCharLen = sc.nextInt();
        char[] passWordStr = new char[sc.nextInt()];
        String charStr = null;

        int[] chkCntArr = new int[DNA.length];
        do {
            charStr = sc.nextLine();
        } while (charStr.length() != dnaCharLen);

        char[] dnacharArr = charStr.toCharArray();
        int chkResCnt = 0;
        for (int i = 0; i < chkCntArr.length; i++) {
            chkCntArr[i] = sc.nextInt();
            if (chkCntArr[i] == 0) {
                chkResCnt++;
            }
        }


        char[] currArr = new char[DNA.length];

    }
}
