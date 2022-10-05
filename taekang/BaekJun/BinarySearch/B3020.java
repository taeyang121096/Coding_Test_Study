package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

public class B3020 {
//    public static int N, H;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        H = Integer.parseInt(st.nextToken());
//
//        /**
//         * 누적합
//         *
//         */
//        int[] down = new int[N / 2];
//        int[] up = new int[N / 2];
//        int idx1 = 0;
//        int idx2 = 0;
//        for (int i = 0; i < N; i++) {
//            if (i % 2 == 0) {
//                down[idx1] = Integer.parseInt(br.readLine());
//                idx1++;
//            } else {
//                up[idx2] = Integer.parseInt(br.readLine());
//                idx2++;
//            }
//        }
//
//        Arrays.sort(down); // 1 3 5
//        Arrays.sort(up); // 1 3 5
//
//        int min = Integer.MAX_VALUE;
//        int cnt = 0;
//
//        for (int i = 1; i <= H; i++) {
//            int num1 = binarySearch(down, i, 0, N / 2);
//            int num2 = binarySearch(up, H - i + 1, 0, N / 2);
//            if (min == num1 + num2) {
//                cnt++;
//            } else if (min > num1 + num2) {
//                min = num1 + num2;
//                cnt = 1;
//            }
//        }
//        System.out.println(min + " " + cnt);
//    }
//
//    public static int binarySearch(int[] arr, int h, int left, int right) {
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (arr[mid] >= h) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return arr.length - right;
//    }
static int N, H;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        int[] bot = new int[H + 2];
        int[] top = new int[H + 2];

        for (int i = 0; i < N / 2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine()) + 1]++;
        }

        for (int i = 1; i <= H; i++) {
            bot[i] += bot[i - 1];
        }

        for (int i = H; i >= 1; i--) {
            top[i] += top[i + 1];
        }

        for (int i = 0; i < H + 2; i++) {
            System.out.println(bot[i] + " " + top[i]);
        }

        int min = N;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            int obs = (bot[H] - bot[i - 1]) + (top[1] - top[i + 1]);

            if (obs < min) {
                min = obs;
                cnt = 1;
            } else if (obs == min)
                cnt++;
        }

        bw.write(min + " " + cnt + "\n");
        bw.flush();

    }
}
