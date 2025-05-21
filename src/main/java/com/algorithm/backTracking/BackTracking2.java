package com.algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <b> BackTracking2 </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2025-05-21
 */
public class BackTracking2 {
    private static int N;
    private static int[] numbers;
    private static int[] operatorCounts; // +, -, *, / 각각의 개수
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수 입력
        N = Integer.parseInt(br.readLine());

        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력 (+, -, *, / 순)
        st = new StringTokenizer(br.readLine(), " ");
        operatorCounts = new int[4];
        for (int i = 0; i < 4; i++) {
            operatorCounts[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹으로 모든 경우의 수 계산
        dfs(1, numbers[0]); // 첫 번째 숫자부터 시작

        // 결과 출력
        System.out.println(max);
        System.out.println(min);
    }

    /**
     * 백트래킹으로 모든 가능한 연산자 조합을 시도하는 메서드
     * @param depth 현재 처리 중인 숫자의 인덱스
     * @param result 현재까지의 계산 결과
     */
    private static void dfs(int depth, int result) {
        // 모든 숫자를 다 사용했을 때
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        // 각 연산자 시도
        for (int i = 0; i < 4; i++) {
            if (operatorCounts[i] > 0) {
                // 연산자 사용
                operatorCounts[i]--;

                // 연산 수행
                int nextResult = calculateResult(result, numbers[depth], i);

                // 다음 숫자 처리
                dfs(depth + 1, nextResult);

                // 연산자 복원 (백트래킹)
                operatorCounts[i]++;
            }
        }
    }

    /**
     * 현재 결과와 다음 숫자, 연산자를 이용해 계산하는 메서드
     * @param current 현재까지의 계산 결과
     * @param next 다음 숫자
     * @param operator 연산자 인덱스 (0:+, 1:-, 2:*, 3:/)
     * @return 계산 결과
     */
    private static int calculateResult(int current, int next, int operator) {
        switch (operator) {
            case 0: return current + next; // 덧셈
            case 1: return current - next; // 뺄셈
            case 2: return current * next; // 곱셈
            case 3: return current / next; // 나눗셈
            default: return 0;
        }
    }
}
