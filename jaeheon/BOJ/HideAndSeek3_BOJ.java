package BOJ;

import java.util.*;
import java.io.*;

public class HideAndSeek3_BOJ {
    static int n;
    static int k;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        if (n >= k) {
            System.out.println(n - k);
            return;
        }
        bfs();
        System.out.println(visit[k]);
    }

    static void bfs() {
        visit = new int[k * 2 + 1];
        Arrays.fill(visit, 100000);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        });

        visit[n] = 1;
        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[0] == k) {
                break;
            }

            int plus = tmp[0] + 1;
            int minus = tmp[0] - 1;
            int mul = tmp[0] * 2;

            // 더하기
            if ((plus <= k * 2 && visit[plus] >= tmp[1] + 1)) {
                q.offer(new int[]{plus, tmp[1] + 1});
                visit[plus] = tmp[1] + 1;
            }
            if (mul > 0) {
                // 빼기
                if ((minus >= 0 && visit[minus] >= tmp[1] + 1)) {
                    q.offer(new int[]{minus, tmp[1] + 1});
                    visit[minus] = tmp[1] + 1;
                }
                // 곱하기
                if ((mul <= k * 2 && visit[mul] >= tmp[1])) {
                    q.offer(new int[]{mul, tmp[1]});
                    visit[mul] = tmp[1];
                }
            }
        }
    }
}
