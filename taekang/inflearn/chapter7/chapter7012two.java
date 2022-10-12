package inflearn.chapter7;

import java.io.*;
import java.util.*;

public class chapter7012two {
    public static int N, M, answer = 0;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        check[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int V) {
        if (V == N) {
            answer++;
        }

        for (int nv : graph.get(V)) { // 1 : {2,3,4} ...
            if (!check[nv]) {
                check[nv] = true;
                dfs(nv); // 2가 들어가서 거기서 또 graph.get(2) -> {1,3} 을 실행... 거기서 또 1,3 에대한 dfs..
                // 하다가 5를 만나면 answer++;
                check[nv] = false;
            }
        }
    }
}
