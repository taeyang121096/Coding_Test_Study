package inflearn.chapter7;

import java.io.*;
import java.util.*;

/**
 * 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5 이동 가능하다
 * 최소 몇번의 점프로 현수가 송아지의 위리까지 갈수 있을까 ?
 */
public class findCowBaby {
    public static int[] dis = {1, -1, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int S = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);

        System.out.println(bfs(S, E));
    }

    public static int bfs(int S, int E) {
        boolean[] check = new boolean[10001];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{S, 0});
        check[S] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == E) {
                return tmp[1];
            }// tmp[0] = 좌표, tmp[1] = 뎁스
            for (int j = 0; j < 3; j++) {
                int nx = tmp[0] + dis[j];
                int lev = tmp[1];
                if (nx >= 1 && nx <= 10000 && !check[nx]) {
                    q.offer(new int[]{nx, lev + 1});
                    check[nx] = true;
                }
            }
        }
        return 0;
    }

//    public static int bfs(int S, int E) {
//        boolean[] check = new boolean[10001];
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(S);
//        check[S] = true;
//        int depth = 0;
//
//        while (!q.isEmpty()) {
//            Integer len = q.size();
//            for (int i = 0; i < len; i++) {
//                int x = q.poll();
//                for (int j = 0; j < 3; j++) {
//                    int nx = x + dis[j];
//                    if (nx == E) return depth + 1;
//                    if (nx >= 1 && nx <= 10000 && !check[nx]) {
//                        check[nx] = true;
//                        q.offer(nx);
//                    }
//                }
//            }
//            depth++;
//        }
//        return 0;
//    }
}

//import java.util.*;
//
//class findCowBaby {
//    int answer = 0;
//    int[] dis = {1, -1, 5};
//    int[] ch;
//    Queue<Integer> Q = new LinkedList<>();
//
//    public int BFS(int s, int e) {
//        ch = new int[10001];
//        ch[s] = 1;
//        Q.offer(s);
//        int L = 0;
//        while (!Q.isEmpty()) {
//            int len = Q.size();
//            for (int i = 0; i < len; i++) {
//                int x = Q.poll();
//                for (int j = 0; j < 3; j++) {
//                    int nx = x + dis[j];
//                    if (nx == e) {
//                        return L + 1;
//                    }
//                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
//                        ch[nx] = 1;
//                        Q.offer(nx);
//                    }
//                }
//            }
//            L++;
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        findCowBaby T = new findCowBaby();
//        Scanner kb = new Scanner(System.in);
//        int s = kb.nextInt();
//        int e = kb.nextInt();
//        System.out.println(T.BFS(s, e));
//    }
//}
