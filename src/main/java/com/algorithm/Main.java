package com.algorithm;



import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 값을 보관 및 정렬 해 줄 deque
        Deque<Node> mydeque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 덱이 비거나, 덱 마지막에 현재 값(now)보다 큰 값 지우기
            while (!mydeque.isEmpty()
                    && mydeque.getLast().getValue() > now) {

                mydeque.removeLast();
            }
            // 덱 마지막에 값 삽입
            mydeque.addLast(new Node(i, now));

            // 덱의 첫번째 인덱스에서 범위를 벗어난 값 지우기
            if(mydeque.getFirst().getIndex() <= i - L) {
                mydeque.removeFirst();
            }

            // 최소값 출력
            bw.write(mydeque.getFirst().getValue() + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

