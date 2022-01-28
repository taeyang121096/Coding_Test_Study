import java.util.*;

public class Island_Pro {
//     최소비용으로 모든 섬이 통행 가능하도록
//     건너 건너도 된다
//     섬은 n 1 ~ 100
//     cost len = (n-1)*n /2
//     0 s 1 e 2 cost
//     무방향 그래프
//

    static int[] parent;

    static int find(int val) {
        if (parent[val] == val)
            return val;
        return parent[val] = find(parent[val]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        Arrays.sort(costs, (o1, o2) -> o1[2] > o2[2] ? 1 : -1);

        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            if (find(a) == find(b))
                continue;
            union(a, b);
            answer += c[2];
        }

        return answer;
    }
}

