package com.algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <b> NQueen </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2025-05-14
 */
public class NQueen {
    private static int N;

    static int[] queens;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);

        queens = new int[N + 1];
        resolve(1);

        System.out.println(count);
    }

    public static void resolve(int row) {
        // 종료 조건
        if (row == N) {
            count++;
            return;
        }

        for (int col = row; col <= N; col++) {
            if (isValid(row, col)) {
                queens[col] = row;
                resolve(row + 1);
            }

        }

    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 퀸이 있는지 확인
            if (queens[i] == col) {
                return false;
            }

            // 대각선에 퀸이 있는지 확인
            // row와 col: 현재 퀸을 놓으려는 위치
            // i와 queens[i]: 이미 놓인 퀸의 위치 (i번째 행의 queens[i]열)
            // 두 값이 같다면 대각선
            if (Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }

        return true;
    }
}
