package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // queuestack의 길이
        int N = Integer.parseInt(br.readLine());

        // 각 자료구조의 동작 방식 (큐 = 0, 스택 = 1)
        String[] pick = br.readLine().split(" ");

        // queuestack의 초기값
        String[] initialValues = br.readLine().split(" ");

        // queuestack 초기화
        StackQue[] stackQues = new StackQue[N];
        for (int i = 0; i < N; i++) {
            stackQues[i] = new StackQue(Integer.parseInt(pick[i]));
            stackQues[i].push(Integer.parseInt(initialValues[i]));
        }

        // 삽입할 수열의 길이
        int M = Integer.parseInt(br.readLine());

        // 삽입할 수열
        String[] inputValues = br.readLine().split(" ");

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int currentValue = Integer.parseInt(inputValues[i]);
            for (int j = 0; j < N; j++) {
                stackQues[j].push(currentValue);
                currentValue = stackQues[j].pop();
            }
            sb.append(currentValue).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static class StackQue {
        private int command; // 0 = 큐, 1 = 스택
        private Deque<Integer> deque = new ArrayDeque<>();

        public StackQue(int command) {
            this.command = command;
        }

        public int pop() {
            // 큐 또는 스택 방식으로 pop 동작 수행
            return (command == 0) ? deque.pollFirst() : deque.pollLast();
        }

        public void push(int value) {
            // 큐 또는 스택 방식으로 push 동작 수행
            if (command == 0) {
                deque.addLast(value); // 큐는 뒤에 삽입
            } else {
                deque.addLast(value); // 스택은 뒤에 삽입
            }
        }
    }
}