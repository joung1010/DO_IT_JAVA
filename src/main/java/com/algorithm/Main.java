package com.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> waitTimeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            waitTimeList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(waitTimeList);
        int totalSum = 0;
        int cumulativeSum = 0;
        for (Integer num : waitTimeList) {
            cumulativeSum += num;
            totalSum += cumulativeSum;
        }

        System.out.println(totalSum);
    }
}


