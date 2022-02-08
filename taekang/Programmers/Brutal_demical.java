package Programmers;

import java.io.*;
import java.util.*;

public class Brutal_demical {

    static char[] arr;
    static boolean[] isUsed;
    static String temp = "";
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); //12
        String numbers = input;
        String[] split = numbers.split("");

        arr = new char[split.length]; // 2
        isUsed = new boolean[split.length]; // 2

        for (int i = 0; i < split.length; i++) {
            find(0, i + 1, numbers);
        }

        /**
         *
         * 3P2 {1,2,3}
         * 12 13 23 21 23 31 32
         *
         * 71
         * 1 7 3P1
         * 17 71 3P2
         */

        System.out.println(set.size());
    }

    static public void find(int level, int index, String numbers) {
        if (level == index) {
            for (int i = 0; i < index; i++) {
                temp += arr[i];
            }
            int number = Integer.parseInt(temp);
            if(isPrime(number))
                set.add(number);
            temp ="";
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[level] = numbers.charAt(i);
                find(level + 1, index, numbers);
                isUsed[i] = false;
            }
        }
    }

    static boolean isPrime(int number) {
        if (number == 0 || number == 1)
            return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
