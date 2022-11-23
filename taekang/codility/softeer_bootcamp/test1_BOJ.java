package codility.softeer_bootcamp;

import java.io.*;
import java.util.*;

public class test1_BOJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);

        int[] distance = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            distance[i] = arr[i+1] - arr[i];
            min = Math.min(distance[i], min);
        }

        int res = 0;
        for(int i = 0; i < distance.length; i++) {
            if(min == distance[i]) {
                res = i;
                break;
            }
        }

        System.out.println(arr[res] + " " + arr[res + 1]);
    }
}