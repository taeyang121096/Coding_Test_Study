package Programmers.Jule;

import java.util.*;

public class PlusWonSo {
    public static void main(String[] args) {
        int[][] queries = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};
        // t2 : [1,1], [1,2], [1,4] [1,8]
        int answer = 0;
        // 배열의 인덱스로 크기를 저장 ? 1000개의 배열이 ...만약
        int[] idx = new int[1001]; //

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int arr_num = queries[i][0]; //
            int add_num = queries[i][1]; //
            if (!map.containsKey(arr_num)) {
                map.put(arr_num, add_num);
                idx[arr_num] = (int) Math.pow(2, (getPow(add_num))); // [2,16] [7,2]
            } else { // map에 있을 때
                int n = map.get(arr_num) + add_num; // 10 + 5

                if (idx[arr_num] > n) { //
                    map.put(arr_num, n);
                } else { //
                    answer += map.get(arr_num); // [2, 24], answer += 15
                    idx[arr_num] = (int) Math.pow(2, getPow(n)); // 32
                    map.put(arr_num, n); // [2, 24];
                }
            }
        }
        System.out.println(answer);
    }

    public static int getPow(int num) {
        int cnt = 1; // 3
        while (num > 1) { //
            num = num / 2; // 1
            cnt++;
        }
        return cnt;
    }
}
