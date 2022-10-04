package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

public class B2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long start = 0;
        long end = n;
        long mid = 0;
        long min = Long.MAX_VALUE;

        while (start <= end) {
            mid = (start + end) / 2;
            long k = (long) Math.pow(mid, 2);

            if (k < n) {
                start = mid + 1;
            } else if (k >= n) {
                end = mid - 1;
            }
        }
        System.out.println(end + 1);
    }
}
