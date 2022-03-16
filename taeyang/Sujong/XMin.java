package Sujong;

import java.io.*;
import java.util.*;

/*

 */
public class XMin {

    public static void main(String[] args) throws IOException {
//        선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        초기화
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        String[] num = br.readLine().split(" ");
//        로직
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] < x) {
                list.add(String.valueOf(arr[i]));
            }
        }
//        출력
        System.out.println(String.join(" ", list));
    }
}
