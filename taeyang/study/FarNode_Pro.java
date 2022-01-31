import java.util.*;

public class FarNode_Pro {

    //     노드 1 ~ n까지
//     1번 노드로 부터 가장 멀리 떨어진 노드의 갯수
//     최단경로로 이동 할 경우 간선의 개수가 가장 많은 노드
//     n 2 ~ 20000
//     간선은 양방향 1 ~ 50000
//     a - b
//     min = 20000
    class Node {
        int idx;
        int min;
        List<Integer> list = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
            min = 20000;
        }
    }

    static List<Node> ls;
    static boolean[] check;

    static void make(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        check[s] = true;
        q.offer(s);
        while (!q.isEmpty()) {
            int t = q.poll();
            List<Integer> list = ls.get(t).list;
            for (int i = 0; i < list.size(); i++) {
                if (check[list.get(i)])
                    continue;
                check[list.get(i)] = true;
                ls.get(list.get(i)).min = Math.min(ls.get(t).min + 1, ls.get(list.get(i)).min);
                q.offer(list.get(i));
            }

        }
    }

    public int solution(int n, int[][] edge) {

        ls = new ArrayList<>();
        check = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            ls.add(new Node(i));
        }
        ls.get(1).min = 0;

        for (int[] e : edge) {
            ls.get(e[0]).list.add(e[1]);
            ls.get(e[1]).list.add(e[0]);
        }

        make(1);

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (max < ls.get(i).min)
                max = ls.get(i).min;
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (max == ls.get(i).min)
                cnt++;
        }

        return cnt;
    }
}

