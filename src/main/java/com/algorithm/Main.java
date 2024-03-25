package com.algorithm;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> numberList = IntStream.range(0, N)
                .mapToObj(i -> sc.nextInt())
                .collect(Collectors.toList());

        numberList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}



