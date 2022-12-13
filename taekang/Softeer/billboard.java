package Softeer;

import java.util.*;
import java.io.*;

public class billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 육각형 모양의 전구 7*5 개로 구성돼있다.
         * 0 : 1 1 1 0 1 1 1
         * 1 : 0, 0, 1, 0, 0, 1, 0
         * 2 : 1, 0, 1, 1, 1, 0, 1
         * 3 : 1, 0, 1, 1, 0, 1, 1
         * 4 : 0, 1, 1, 1, 0, 1, 0
         * 5 : 1, 1, 0, 1, 0, 1, 1
         * 6 : 1, 1, 0, 1, 1, 1, 1
         * 7 : 1, 1, 1, 0, 0, 1, 0
         * 8 : 1, 1, 1, 1, 1, 1, 1
         * 9 : 1, 1, 1, 1, 0, 1, 1
         */
        ArrayList<int[]> list = new ArrayList<>
                (List.of(new int[]{1, 1, 1, 0, 1, 1, 1} // 0
                        , new int[]{0, 0, 1, 0, 0, 1, 0} // 1
                        , new int[]{1, 0, 1, 1, 1, 0, 1} // 2
                        , new int[]{1, 0, 1, 1, 0, 1, 1} // 3
                        , new int[]{0, 1, 1, 1, 0, 1, 0} // 4
                        , new int[]{1, 1, 0, 1, 0, 1, 1} // 5
                        , new int[]{1, 1, 0, 1, 1, 1, 1} // 6
                        , new int[]{1, 1, 1, 0, 0, 1, 0} // 7
                        , new int[]{1, 1, 1, 1, 1, 1, 1} // 8
                        , new int[]{1, 1, 1, 1, 0, 1, 1} // 9
                ));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int answer = 0;
            String[] str = br.readLine().split(" ");
            String a = str[0];
            String b = str[1];

            int len_a = a.length(); // 4
            int len_b = b.length(); // 5
            int first_len = Math.abs(len_b - len_a); // 5 -4 = 1
            int max_len = Math.max(len_a, len_b);

            if (len_a <= len_b) {
                for (int i = 0; i < first_len; i++) {
                    int in = b.charAt(i) - 48;
                    int[] ints = list.get(in);
                    for (int j = 0; j < ints.length; j++) {
                        if (ints[j] == 1) {
                            answer++;
                        }
                    }
                }
                for (int i = first_len; i < max_len; i++) { // 1 2 3 4
                    int one = a.charAt(i - first_len) - 48;
                    int two = b.charAt(i) - 48;
                    int[] one_arr = list.get(one);
                    int[] two_arr = list.get(two);
                    for (int j = 0; j < one_arr.length; j++) {
                        if (one_arr[j] != two_arr[j]) {
                            answer++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < first_len; i++) {
                    int in = a.charAt(i) - 48;
                    int[] ints = list.get(in);
                    for (int j = 0; j < ints.length; j++) {
                        if (ints[j] == 1) {
                            answer++;
                        }
                    }
                }

                for (int i = first_len; i < max_len; i++) { // 1 2 3 4
                    int one = a.charAt(i) - 48;
                    int two = b.charAt(i - first_len) - 48;
                    int[] one_arr = list.get(one);
                    int[] two_arr = list.get(two);
                    for (int j = 0; j < one_arr.length; j++) {
                        if (one_arr[j] != two_arr[j]) {
                            answer++;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }
}