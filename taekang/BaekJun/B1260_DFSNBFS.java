package BaekJun;

import java.io.*;
import java.util.*;

public class B1260_DFSNBFS {
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split(" ");

        n = Integer.parseInt(str[0]); // 4
        int M = Integer.parseInt(str[1]); // 5
        int V = Integer.parseInt(str[2]); // 1, 시작 정점

        list = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String input2 = br.readLine();
            String[] str2 = input2.split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);

            // 양방향
            list[a].add(b);
            list[b].add(a);
        }

        dfs(V);
        System.out.println();

        check = new boolean[n + 1];
        bfs(V);
        System.out.println();
    }

    static void dfs(int start) { // 1
        if (check[start]) { // {f,t,f,f,f}
            return;
        }

        check[start] = true;
        System.out.print(start + " ");
        for (int y : list[start]) { // list[1]에 해당하는 것들.. 에 대해서 반복문을 돈다.{1,2} {1,3} {1,4} -> 2,3,4
            if (!check[y]) {
                dfs(y);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 2 3 4
        check[start] = true; // {f,t,t,t,t}

        while (!queue.isEmpty()) {
            int x = queue.poll(); // 2
            System.out.print(x + " "); // 1 2
            for (int y : list[x]) // 2, 3, 4
                if (!check[y]) {
                    check[y] = true;
                    queue.add(y);
                }
        }
    }
}

