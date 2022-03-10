import java.util.*;

public class BaeDal_Pro {


    //     n 1 ~ 50
//     road 1 ~ 2000
//     a : 노드 b : 노드 c : 시간 (1 ~ 1만)
//     다익스트라
//
    class Node {
        int idx;
        int cost;
        List<Node> list;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
            this.list = new ArrayList<>();
        }
    }

    static boolean[] check;
    static Map<Integer, Node> map = new HashMap<>();
    static int[] cost;

    static void dijesktra() {

        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.cost > n2.cost ? 1 : -1;
            }

        });
        q.offer(map.get(1));


        while (!q.isEmpty()) {
            Node tmp = q.poll();
            check[tmp.idx] = true;
            for (Node n : tmp.list) {
                if (check[n.idx])
                    continue;
                if (cost[n.idx] > cost[tmp.idx] + n.cost) {
                    cost[n.idx] = cost[tmp.idx] + n.cost;
                    map.get(n.idx).cost = cost[tmp.idx] + n.cost;
                    q.offer(map.get(n.idx));
                }

            }

        }

    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        check = new boolean[N + 1];
        cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        check[1] = true;
//         초기화

//         노드 연결
        for (int[] tmp : road) {
            if (map.containsKey(tmp[0])) {
                map.get(tmp[0]).list.add(new Node(tmp[1], tmp[2]));
            } else {
                map.put(tmp[0], new Node(tmp[0], cost[tmp[0]]));
                map.get(tmp[0]).list.add(new Node(tmp[1], tmp[2]));
            }
            if (map.containsKey(tmp[1])) {
                map.get(tmp[1]).list.add(new Node(tmp[0], tmp[2]));
            } else {
                map.put(tmp[1], new Node(tmp[1], cost[tmp[1]]));
                map.get(tmp[1]).list.add(new Node(tmp[0], tmp[2]));
            }
        }

        dijesktra();

//         값 찾아주기
        for (int c : cost) {
            if (c <= K)
                answer++;
        }
        return answer;
    }
}

