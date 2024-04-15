package com.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalNum = Integer.parseInt(br.readLine());
        int[] intArr = new int[totalNum];
        for (int i = 0; i < totalNum; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(intArr, calculateMaxDigits(intArr));

        for (int value : intArr) {
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr, int maxDigits) {
        int place = 1;

        for (int digit = 0; digit < maxDigits; digit++) {
            int[] output = new int[arr.length];
            int[] count = new int[10];

            for (int num : arr) {
                count[(num / place) % 10]++;
            }

            for (int i = 1; i < 10; i++) {// 누적합을 계산하는 이유는 각 숫자(0-9)에 대해 해당 숫자를 기준으로 한 원소들이 결과 배열(output)에서 시작할 인덱스를 정확하게 지정
                // 예를 들어, count[1]의 값이 5라면, 숫자 1을 포함해 1보다 작은 숫자(즉, 0과 1)의 원소들이 배열에서 0번부터 4번 인덱스까지 차지
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int num = arr[i];
                int index = (num / place) % 10;
                output[count[index] - 1] = num;
                count[index]--;
            }

            System.arraycopy(output, 0, arr, 0, arr.length);
            place *= 10;
        }
        /*
        * 카운팅:
각 숫자의 1의 자리를 보고 count 배열에 기록합니다.

170의 1의 자리는 0
45의 1의 자리는 5
75의 1의 자리는 5
90의 1의 자리는 0
802의 1의 자리는 2
따라서 count 배열은: [2, 0, 1, 0, 0, 2, 0, 0, 0, 0] (0이 2개, 2가 1개, 5가 2개)

누적합 계산:
count 배열의 각 값을 이전 값들과 합쳐 누적합을 계산합니다.

초기: [2, 0, 1, 0, 0, 2, 0, 0, 0, 0]
계산 후: [2, 2, 3, 3, 3, 5, 5, 5, 5, 5]
정렬 수행:
원 배열의 끝에서부터 순회하면서 output 배열에 숫자를 배치합니다.

802는 2의 자리, count[2]는 3이므로 output[2] 위치에 배치하고 count[2]는 2가 됩니다.
90는 0의 자리, count[0]는 2이므로 output[1] 위치에 배치하고 count[0]는 1이 됩니다.
75는 5의 자리, count[5]는 5이므로 output[4] 위치에 배치하고 count[5]는 4가 됩니다.
45는 5의 자리, count[5]는 4이므로 output[3] 위치에 배치하고 count[5]는 3이 됩니다.
170는 0의 자리, count[0]는 1이므로 output[0] 위치에 배치하고 count[0]는 0이 됩니다.
결과 배열: [170, 90, 802, 45, 75]

두 번째 단계: 10의 자리 정렬
동일한 프로세스를 반복하여 10의 자리를 기준으로 정렬합니다.

결과 배열: [802, 170, 45, 75, 90]

세 번째 단계: 100의 자리 정렬
마지막으로 100의 자리를 기준으로 정렬합니다.

최종 결과: [45, 75, 90, 170, 802]
        *
        * */
    }



    private static int calculateMaxDigits(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return Integer.toString(max).length();
    }
}
