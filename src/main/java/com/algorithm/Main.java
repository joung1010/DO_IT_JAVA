package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());


        int N = Integer.parseInt(tokenizer.nextToken());
        int quiz = Integer.parseInt(tokenizer.nextToken());

        int[][] table = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] sumTable = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumTable[i][j] = (sumTable[i][j - 1] + sumTable[i - 1][j] - sumTable[i - 1][j - 1] + table[i][j]);
            }
        }




        for (int q = 0; q < quiz; q++) {
            tokenizer = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            System.out.println(sumTable[x2][y2] - sumTable[x1 - 1][y2] - sumTable[x2][y1 - 1] + sumTable[x1 - 1][y1 - 1]);
        }

    }
}
