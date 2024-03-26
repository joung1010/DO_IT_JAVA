package com.algorithm;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();

        String sortedNum = Arrays.asList(String.valueOf(number).split(""))
                .stream()
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(sortedNum);
    }
}


