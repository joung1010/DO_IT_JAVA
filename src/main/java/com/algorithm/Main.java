package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 음수 인덱스를 처리하기 위해 오프셋 50을 사용
    // visited[a+50][b+50][c+50]로 접근
    public static int[][][] memo = new int[101][101][101];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 메모이제이션 배열 초기화 (-1로 초기화하여 미계산 상태 표시)
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        String line;
        while ((line = br.readLine()) != null) {
            String[] nums = line.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);

            // 종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = w(a, b, c);
            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, result));
        }

        System.out.print(sb);
    }

    public static int w(int a, int b, int c) {
        // 기저 조건들
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 메모이제이션 확인 (유효한 범위에서만)
        if (memo[a + 50][b + 50][c + 50] != -1) {
            return memo[a + 50][b + 50][c + 50];
        }

        int result;
        if (a < b && b < c) {
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        // 결과 저장
        memo[a + 50][b + 50][c + 50] = result;
        return result;
    }
}
