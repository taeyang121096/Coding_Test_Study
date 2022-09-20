package BaekJun.BinarySearch;

import java.io.*;
import java.util.*;

public class B10815_NumberCard {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


//        List<Integer> N_list = new ArrayList<>();
//        List<Integer> M_list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] N_list = new int[N];

        st = new StringTokenizer(br.readLine()); // 6 3 2 10 -10
        for (int i = 0; i < N; i++) {
            N_list[i] = (Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int[] ans = new int[M];

        Arrays.sort(N_list); // -10 2 3 6 10

        String input = br.readLine();
        String[] str = input.split(" ");
        int[] M_List = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            M_List[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < M_List.length; i++) {
            if (binarySearch(N_list, M_List[i])) {
                ans[i] = 1;
            } else
                ans[i] = 0;
        }

        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] == target)
                return true;
            else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
