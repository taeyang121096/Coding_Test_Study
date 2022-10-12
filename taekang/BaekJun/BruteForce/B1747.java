package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 31
        for (int i = N; i <= 1004000; i++) {
            if (isPrime(i)) { // 만약 소수이면
                // 만약 팰린드롬이면 break 하면되지않나
                if (isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean isPalindrome(int N) {
        // 3 1
        char[] arr = String.valueOf(N).toCharArray();
        if (arr.length % 2 == 0) { // 길이가 짝수일떄
            for (int i = 0; i < arr.length / 2; i++) { // 324 | 432
                if (!(arr[i] == arr[arr.length - 1 - i])) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < arr.length / 2; i++) { // 79 1 97, 2
                if (!(arr[i] == arr[arr.length - 1 - i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;

        if (number == 2)
            return true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
