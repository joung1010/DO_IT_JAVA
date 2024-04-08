package com.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount = Integer.parseInt(st.nextToken());
        int targetIdx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }

        int targetNum = integerList.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .skip(targetIdx - 1)
                .findFirst()
                .orElse(0);

        System.out.println(targetNum);
    }
}


