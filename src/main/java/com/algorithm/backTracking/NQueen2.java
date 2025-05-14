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
public class NQueen2 {
    private static int N;
    private static int count = 0;

    // 각 열과 대각선에 퀸이 있는지 여부를 저장
    private static boolean[] colUsed;        // 세로 방향 체크
    private static boolean[] diag1Used;      // / 방향 대각선 체크 (row + col)
    private static boolean[] diag2Used;      // \ 방향 대각선 체크 (row - col + N - 1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        colUsed = new boolean[N];
        diag1Used = new boolean[2 * N - 1];  // / 방향 대각선은 최대 2N-1개
        diag2Used = new boolean[2 * N - 1];  // \ 방향 대각선은 최대 2N-1개

        resolve(0);

        System.out.println(count);
    }


    private static void resolve(int row) {
        if (row == N) {
            // N개의 퀸을 모두 배치했으면 카운트 증가
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            int diag1Index = row + col;              // / 방향 대각선 인덱스
            int diag2Index = row - col + N - 1;      // \ 방향 대각선 인덱스

            // 열과 대각선 체크
            if (!colUsed[col] && !diag1Used[diag1Index] && !diag2Used[diag2Index]) {
                // 현재 위치에 퀸 배치
                colUsed[col] = true;
                diag1Used[diag1Index] = true;
                diag2Used[diag2Index] = true;

                // 다음 행으로 이동
                resolve(row + 1);

                // 백트래킹: 현재 위치의 퀸 제거
                colUsed[col] = false;
                diag1Used[diag1Index] = false;
                diag2Used[diag2Index] = false;
            }
        }
    }
}

/*
1. 우상향 대각선(/) 인덱스: row + col
수학적 원리:
우상향 대각선 상에 있는 모든 칸들은 행 번호와 열 번호의 합이 동일합니다.
예를 들어 N=8인 체스판에서 각 칸의 row + col 값을 계산해보면:
        0  1  2  3  4  5  6  7  <- 열(col) 인덱스
---------------------------
        0| 0  1  2  3  4  5  6  7
        1| 1  2  3  4  5  6  7  8
        2| 2  3  4  5  6  7  8  9
        3| 3  4  5  6  7  8  9  10
        4| 4  5  6  7  8  9  10 11
        5| 5  6  7  8  9  10 11 12
        6| 6  7  8  9  10 11 12 13
        7| 7  8  9  10 11 12 13 14
        ↑
행(row) 인덱스
위 그림에서 같은 값을 가진 칸들이 같은 우상향 대각선 상에 있습니다.

        값 7인 대각선: (0,7), (1,6), (2,5), (3,4), (4,3), (5,2), (6,1), (7,0)
값 4인 대각선: (0,4), (1,3), (2,2), (3,1), (4,0)

따라서 diag1Used[row + col]가 true이면 해당 우상향 대각선에 이미 퀸이 있다는 의미입니다.
2. 우하향 대각선(\) 인덱스: row - col + N - 1
수학적 원리:
우하향 대각선 상에 있는 모든 칸들은 행 번호와 열 번호의 차이가 동일합니다. 그러나 이 차이는 음수가 될 수 있으므로, 배열 인덱스로 사용하기 위해 N-1을 더해 양수로 만듭니다.
N=8인 체스판에서 각 칸의 row - col + (N-1) 값을 계산해보면:
        0  1  2  3  4  5  6  7  <- 열(col) 인덱스
---------------------------
        0| 7  6  5  4  3  2  1  0
        1| 8  7  6  5  4  3  2  1
        2| 9  8  7  6  5  4  3  2
        3| 10 9  8  7  6  5  4  3
        4| 11 10 9  8  7  6  5  4
        5| 12 11 10 9  8  7  6  5
        6| 13 12 11 10 9  8  7  6
        7| 14 13 12 11 10 9  8  7
        ↑
행(row) 인덱스
위 그림에서 같은 값을 가진 칸들이 같은 우하향 대각선 상에 있습니다.

        값 7인 대각선: (0,0), (1,1), (2,2), (3,3), (4,4), (5,5), (6,6), (7,7)
값 10인 대각선: (3,0), (4,1), (5,2), (6,3), (7,4)

N-1을 더하는 이유
row - col은 음수가 될 수 있습니다. 예를 들어:

        (0,7) 위치에서는 0 - 7 = -7

배열 인덱스는 음수가 될 수 없으므로, 모든 값을 양수로 만들기 위해 N-1을 더합니다. N=8일 때:

가능한 row - col 범위: -(N-1) ~ (N-1), 즉 -7 ~ 7
        +N-1을 더하면: 0 ~ 2(N-1), 즉 0 ~ 14

이렇게 하면 모든 우하향 대각선을 0부터 시작하는 고유한 양수 인덱스로 표현할 수 있습니다.
예시로 확인하기
체스판에서 특정 위치에 있는 퀸들이 같은 대각선 상에 있는지 확인해 봅시다:

우상향 대각선(/) 체크:

        (2,3) 위치의 인덱스: 2 + 3 = 5
        (4,1) 위치의 인덱스: 4 + 1 = 5
두 위치는 같은 우상향 대각선 상에 있습니다.


        우하향 대각선(\) 체크:

        (1,3) 위치의 인덱스(N=8): 1 - 3 + 7 = 5
        (3,5) 위치의 인덱스(N=8): 3 - 5 + 7 = 5
두 위치는 같은 우하향 대각선 상에 있습니다.



직관적 이해를 위한 시각화
8x8 체스판에서 대각선을 시각화해보면:
우상향 대각선(/) - row + col이 같음
   0 1 2 3 4 5 6 7
           +-----------------+
           0 | 0 1 2 3 4 5 6 7 |
           1 | 1 2 3 4 5 6 7 8 |
           2 | 2 3 4 5 6 7 8 9 |
           3 | 3 4 5 6 7 8 9 10|
           4 | 4 5 6 7 8 9 10 11|
           5 | 5 6 7 8 9 10 11 12|
           6 | 6 7 8 9 10 11 12 13|
           7 | 7 8 9 10 11 12 13 14|
           +-----------------+
우하향 대각선(\) - row - col + (N-1)이 같음
   0 1 2 3 4 5 6 7
           +-----------------+
           0 | 7 6 5 4 3 2 1 0 |
           1 | 8 7 6 5 4 3 2 1 |
           2 | 9 8 7 6 5 4 3 2 |
           3 | 10 9 8 7 6 5 4 3 |
           4 | 11 10 9 8 7 6 5 4 |
           5 | 12 11 10 9 8 7 6 5 |
           6 | 13 12 11 10 9 8 7 6 |
           7 | 14 13 12 11 10 9 8 7 |
           +-----------------+
최종 정리

우상향 대각선(/) 인덱스: row + col

같은 우상향 대각선 상의 모든 칸은 행과 열의 합이 동일
가능한 값 범위: 0 ~ 2(N-1)


우하향 대각선(\) 인덱스: row - col + (N-1)

같은 우하향 대각선 상의 모든 칸은 행과 열의 차이가 동일
+N-1은 음수 인덱스를 방지하기 위한 오프셋
가능한 값 범위: 0 ~ 2(N-1)*/
