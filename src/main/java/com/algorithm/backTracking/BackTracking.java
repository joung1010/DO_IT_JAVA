package com.algorithm.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <b> BackTracking </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2025-04-23
 */
public class BackTracking {
    //    백트래킹의 핵심인 '선택 후 되돌아오기'
//    이미 선택한 숫자를 다시 선택하지 않도록 하는 로직 구현
//    재귀 호출
    static int N, M;
    static int[] selected;  // 현재 선택된 수열을 저장할 배열
    static boolean[] visited;  // 각 숫자의 사용 여부를 체크할 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        selected = new int[M];  // M개의 숫자를 선택할 배열
        visited = new boolean[N + 1];  // 1~N까지의 숫자 사용 여부 (0번 인덱스는 사용하지 않음)

        // 백트래킹 시작
        backtrack(0);

        System.out.print(sb);
    }

    // depth: 현재까지 선택한 숫자의 개수
    public static void backtrack(int depth) {
        // 기저 조건: M개의 숫자를 모두 선택했을 때
        if (depth == M) {
            // 선택된 수열 출력
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지의 숫자 중에서 선택
        for (int i = 1; i <= N; i++) {
            // 아직 선택하지 않은 숫자라면
            if (!visited[i]) {
                // 1. 현재 숫자 선택
                visited[i] = true;  // 방문 표시
                selected[depth] = i;  // 현재 위치에 숫자 저장

                // 2. 다음 위치로 재귀 호출
                backtrack(depth + 1);

                // 3. 백트래킹: 선택 취소 (다른 경로 탐색을 위해)
                visited[i] = false;  // 방문 표시 해제
            }
        }
    }
}
