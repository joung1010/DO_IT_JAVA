package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static int strLen;
    static int passwordLen;
    static char[] str;
    static int[] checkArr = new int[4];
    static int[] myArr = new int[4];
    static int checkCnt = 0; // {‘A’, ‘C’, ‘G’, ‘T’} 중 최소 개수를 일치한 문자 개수 (0~4)
    static int answer = 0; // 만들 수 있는 비밀번호 개수

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        strLen = Integer.parseInt(st.nextToken());
        passwordLen = Integer.parseInt(st.nextToken());
        str = br.readLine().toCharArray(); // DNA 문자열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < passwordLen; i++) { // 첫 부분문자열 셋팅 (0~p_len-1) 까지
            if (str[i]=='A') myArr[0]++;
            if (str[i]=='C') myArr[1]++;
            if (str[i]=='G') myArr[2]++;
            if (str[i]=='T') myArr[3]++;
        }

        if (isRightPassword())// {‘A’, ‘C’, ‘G’, ‘T’} 4개의 문자가 모두 최소개수를 만족했다면
            answer++; // 만들 수 있는 비밀번호 개수 증가

        int i = -1;
        /**
         * 부분문자열 만들기 => 이전 부분문자열의 첫 문자는 제외하고, 끝에서 1문자를 더 추가한다.
         */
        for (int j = passwordLen; j < strLen; j++) { // 부분문자열의 끝을 나타내는 위치
            i = j - passwordLen; // 이전 부분문자열의 시작을 나타내는 위치

            // 이전 부분문자열의 시작 문자 제외
            if (str[i]=='A') myArr[0]--;
            if (str[i]=='C') myArr[1]--;
            if (str[i]=='G') myArr[2]--;
            if (str[i]=='T') myArr[3]--;

            // 이전 부분문자열의 끝에서 1문자 추가
            if (str[j]=='A') myArr[0]++;
            if (str[j]=='C') myArr[1]++;
            if (str[j]=='G') myArr[2]++;
            if (str[j]=='T') myArr[3]++;

            if (isRightPassword())// {‘A’, ‘C’, ‘G’, ‘T’} 4개의 문자가 모두 최소개수를 만족했다면
                answer++; // 만들 수 있는 비밀번호 개수 증가
        }

        System.out.println(answer);

    }

    private static boolean isRightPassword() {
        return IntStream.range(0, checkArr.length)
                .allMatch(i -> myArr[i] >= checkArr[i]);
    }
}
