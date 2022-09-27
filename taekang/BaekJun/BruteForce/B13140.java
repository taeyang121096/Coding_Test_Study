package BaekJun.BruteForce;

import java.io.*;
import java.util.*;

public class B13140 {
    static boolean[] visit;
    static int[] arr;
    static int n;
    static int[] hello = {1, 2, 3, 3, 4};
    static int[] world = {5, 4, 6, 3, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[10];
        arr = new int[7];
        dfs(0);
        if (sb.length() == 0) {
            System.out.println("No Answer");
        }
    }

    static void dfs(int depth) {
        if (depth == 7) {
            if (arr[hello[0]] == 0 || arr[world[0]] == 0) {
                return;
            }

            int sum = 0;

            sum += arr[hello[0]] * 10000 + arr[hello[1]] * 1000 + arr[hello[2]] * 100 + arr[hello[3]] * 10 + arr[hello[4]];
            sum += arr[world[0]] * 10000 + arr[world[1]] * 1000 + arr[world[2]] * 100 + arr[world[3]] * 10 + arr[world[4]];

            if (sum == n) {
                sb.append("  ");
                for (int i = 0; i < 5; i++) {
                    sb.append(arr[hello[i]]);
                }
                sb.append("\n" + "+ ");
                for (int i = 0; i < 5; i++) {
                    sb.append(arr[world[i]]);
                }

                sb.append("\n" + "-------" + "\n");

                if (sum >= 100000) {
                    sb.append(" ");
                    sb.append(sum);
                } else if (sum < 100000) {
                    sb.append("  ");
                    sb.append(sum);
                }

//                sb.append("\n");
                System.out.println(sb.toString());
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
//public class B13140 {
//    public static int N, OplusD, L, r, o, d, e, h, w;
//    public static int[] choice, arr;
//    public static boolean[] check;
//    public static ArrayList<String> list = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        L = (N % 100) / 20; // -> l
//        r = ((N % 1000)) / 100 - L; // -> r
//        OplusD = (N % 100) - (L * 20);
//
//        choice = new int[2];
//        check = new boolean[10];
//
//        check[L] = true;
//        check[r] = true;
//
//        dfs(0, 0);
//        if (list.size() == 0) {
//            System.out.println("No Answer");
//        } else {
//            System.out.print(list.get(0));
//        }
//    }
//
//    public static void makeE() {
//        o = choice[0]; // 4
//        d = choice[1]; // 7
//        e = N % 10000 / 1000 - o; // 2
//        if (o < 0 || d < 0 || e < 0 || L < 0 || r < 0)
//            return;
//
//        int HplusW = N / 10000;
//        boolean[] isUsed = new boolean[10];
//
//        isUsed[o] = true;
//        isUsed[d] = true;
//        isUsed[e] = true;
//        isUsed[L] = true;
//        isUsed[r] = true;
//
//        h = 0;
//        w = 0;
//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                if (!isUsed[j] && !isUsed[i]) {
//                    if (i + j == HplusW) {
//                        h = i;
//                        w = j;
//                    }
//                }
//            }
//        }
//
//        int one = h * 10000 + e * 1000 + L * 100 + L * 10 + o;
//        int two = w * 10000 + o * 1000 + r * 100 + L * 10 + d;
//
//        String str = "";
//        if (one + two == N) {
//            str += "  " + one + "\n";
//            str += "+ " + two + "\n";
//            str += "-------" + "\n";
//            if (N >= 100000)
//                str += " " + N;
//            else
//                str += "  " + N;
//            list.add(str);
//        }
//    }
//
//    public static void dfs(int depth, int Sum) {
//        if (depth == 2) {
//            if (Sum == OplusD) {
//                makeE();
//            }
//            return;
//        }
//
//        for (int i = 0; i < 10; i++) {
//            if (!check[i]) {
//                check[i] = true;
//                choice[depth] = i;
//                dfs(depth + 1, Sum + i);
//                check[i] = false;
//            }
//        }
//    }
//}
