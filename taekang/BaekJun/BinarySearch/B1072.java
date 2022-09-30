package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

/**
 * 게임 횟수 X, 이긴 게임 Y (Z%) Z가 변하는지 ?
 */
public class B1072 {
    public static int get, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        get = (int) ((long) Y * 100 / X);
//        get = (int) ((long) Y * 100 / X) + 1;
        if (get >= 98) {
            System.out.println(-1);
        } else {
            int n = binarySearch();
            System.out.println(n);
        }
    }

    public static int binarySearch() {
        int start = 1;
        int end = 1000000000;
        int mid;
        int tmp;

        while (start <= end) {
            mid = (start + end) / 2; // 500000000
            tmp = (int) (((long) Y + mid) * 100 / (X + mid));
            if (tmp > get) {
//            if(tmp >= get){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
