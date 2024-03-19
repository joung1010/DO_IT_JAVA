package com.algorithm;


import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            int diff = Integer.compare(Math.abs(x), Math.abs(y));
            return (diff == 0) ? Integer.compare(x, y) : diff;
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                System.out.println(queue.isEmpty() ? "0" : queue.poll());
            } else {
                queue.add(num);
            }
        }
    }
}



