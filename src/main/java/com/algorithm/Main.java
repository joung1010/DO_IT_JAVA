package com.algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Node[] nodeArray = new Node[N];
        for (int i = 0; i < N; i++) {
            nodeArray[i] = new Node(Integer.parseInt(bf.readLine()), i);
        }

        Arrays.sort(nodeArray);
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (result < nodeArray[i].index - i) {
                result = nodeArray[i].index - i;
            }
        }
        System.out.println(result + 1);
    }

    static class Node implements Comparable<Node> {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}


