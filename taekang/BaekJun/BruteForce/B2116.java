package BaekJun.BruteForce;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 주사위, 각 면 1~6 마주보는 면에 7이 되는건 아님 (반드시)
 * 1번 주사위 윗면의 숫자는 2번 주사위 아랫면의 숫자와 같다...반복, 1번 주사위는 맘대로 가능
 * A B C D E F -> {A-F, B-D, C-E}
 */

public class B2116 {
    public static int N;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[6];
            for (int j = 0; j < 6; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr);
        }

        int[][] idx = {{0, 5}, {1, 3}, {2, 4}, {3, 1}, {4, 2}, {5, 0}};
        int[] first_arr = list.get(0); // 2 3 1 6 5 4

        for (int i = 0; i < 6; i++) {
            ArrayList<Integer> get_list = new ArrayList<>();
            int start = first_arr[idx[i][0]]; // [0][1], [0][0]
            int end = first_arr[idx[i][1]]; // [0][0], [0][1]
//            System.out.println("start, end : " + start + " " + end);
//                System.out.println("start : " + start + " end : " + end);
            int max = Integer.MIN_VALUE;
            for (int k = 0; k < 6; k++) {
                if (start != first_arr[k] && end != first_arr[k]) {
                    if (max < first_arr[k]) {
                        max = first_arr[k];
                    }
                }
            }
            get_list.add(max);

            for (int j = 1; j < N; j++) { // 1,2,3,4
                int[] comp_arr = list.get(j);

                for (int k = 0; k < 6; k++) {
                    if (end == comp_arr[k]) { // 만약 4라면 ?...end가, B랑 엮여야겠지
                        start = comp_arr[idx[k][0]]; // start를 4로 만들어놓고
                        end = comp_arr[idx[k][1]];
                        break;
                    }
                }

                max = Integer.MIN_VALUE;
                for (int k = 0; k < 6; k++) {
                    if (start != first_arr[k] && end != first_arr[k]) {
                        if (max < first_arr[k]) {
                            max = first_arr[k];
                        }
                    }
                }
                get_list.add(max);
//                System.out.println("start, end : " + start + " " + end);
            }
//            System.out.println("----------------");
            int sum = 0;
            for (int j = 0; j < get_list.size(); j++) {
                sum += get_list.get(j);
            }
//            System.out.println(sum);
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}
