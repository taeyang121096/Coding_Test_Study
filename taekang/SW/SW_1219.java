package SW;

import java.io.*;
import java.util.*;

public class SW_1219 {
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            map = new int[100][100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            if(bfs(0)){
                System.out.println("#" + N + " " + 1);
            } else
                System.out.println("#" + N + " " + 0);
        }
    }

    public static boolean bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[100];
        check[r] = true;
        q.offer(r);

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == 99) {
                return true;
            }
            for (int i = 0; i < 100; i++) {
                if(!check[i] && map[poll][i] == 1){ // 만약 방문한적이 없고 map[0][1] 이 1이라면
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
        return false;
    }
}
