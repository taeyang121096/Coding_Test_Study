package Programmers;

import java.util.*;

public class MakeBigNum {
    public static String[] numbers;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static String[] arr;

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        numbers = new String[number.length()];
        arr = new String[number.length() - k];

        for (int i = 0; i < number.length(); i++) {
            numbers[i] = String.valueOf(number.charAt(i));
        }

        dfs(numbers.length, number.length() - k, 0, 0);

        Integer max = Collections.max(list);
        String answer = String.valueOf(max);

        System.out.println(answer);
    }

    static public void dfs(int N, int k, int select, int index) { // 7, 4, 0
        int max = 0;

        // 종료조건
        if (k == select) {
            String tmp = "";
            for (String in : arr) {
                tmp += in;
            }
            int n = Integer.parseInt(tmp);
            list.add(n);

            return;
        }

        if (index >= N) {
            return;
        }

        // 선택이 되는 경우
        arr[select] = numbers[index];
        dfs(N, k, select + 1, index + 1);

        // 선택이 되지 않는 경우
        dfs(N, k, select, index + 1);
    }
}
