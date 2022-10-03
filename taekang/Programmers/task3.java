package Programmers;

import java.io.*;
import java.util.*;

public class task3 {
    public static int[] sung_cnt = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    public static boolean[] visited = new boolean[10];
    public static int[] choice;
    public static HashSet<String> set = new HashSet<>();
    public static int answer = 0;
    public static int k = 5;

    public static void main(String[] args) throws IOException {
        choice = new int[10];
        for (int i = 1; i <= 10; i++) {
            dfs(0, i, 0);
        }
        System.out.println(set.size());
    }
//    public static int sum(int M){
//        int sum = 0;
//        for(int i = 0; i < M; i++){
//            sum += sung_cnt[choice[i]];
//        }
//        return sum;
//    }

    public static void dfs(int depth, int M, int sum) {
        if (depth == M) {
//            for (int i = 0; i < M; i++) {
//                System.out.print(choice[i] + " ");
//            }
//            System.out.println();
            return;
        }
        if (sum == k) {
            String s = "";
            for (int i = 0; i < depth; i++) {
                s += String.valueOf(choice[depth]);
            }
//            System.out.println();
            set.add(s);
            return;
        }
        for (int i = 0; i < 10; i++) {
            choice[depth] = i;
            dfs(depth + 1, M, sum + sung_cnt[choice[depth]]);
        }
    }
}
// for(int i = 0; i < M; i++){
//     System.out.print(choice[i] + " ");
// }
// System.out.println();
//            if(sum(M) == k){
//                for(int i = 0; i < M; i++){
//                    System.out.print(choice[i] + " ");
//                }
//                System.out.println();
//                answer++;
//            }