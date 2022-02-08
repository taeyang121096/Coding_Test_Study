package Programmers;

import java.io.*;

public class Brutal_carpet {

    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int brown = Integer.parseInt(br.readLine());
        int yellow = Integer.parseInt(br.readLine());
        int[] answer = new int[2];

        int num = brown + yellow;

        int b = 3;
        int a = (brown + 4) / 2 - b;

        for (int i = 1; i <= num; i++) {
            if(num % i == 0)
                count++;
        }

        arr = new int[count];

        find(num, 0, 1);

        // arr[i] = {1,2,3,4,6,12}
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] * ((brown + 4) / 2 - arr[i]) == num) && ((brown + 4) / 2 >= arr[i])) {
                answer[1] = arr[i]; // 세로
                answer[0] = num / arr[i]; // 가로
                break;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }

    public static void find(int number, int start, int index) {
        if (index == number || start > count)
            return;

        if (number % index == 0) {
            arr[start] = index;
            find(number, start + 1, index + 1);
        } else {
            find(number, start, index + 1);
        }
    }
}
