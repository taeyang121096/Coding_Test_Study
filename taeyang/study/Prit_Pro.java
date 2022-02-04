import java.util.*;

public class Prit_Pro {


    static Deque<Integer> q = new ArrayDeque<>();
    static int[] P;
    static int idx;

    static void check() {
        int max = -1;
        for (int i : q) {
            if (P[i] > max) {
                max = P[i];
                idx = i;
            }
        }


    }

    //          1
//     1 1 1 1 1
    public int solution(int[] priorities, int location) {

        P = priorities;

        for (int i = 0; i < P.length; i++) {
            q.offer(i);
        }

        int cnt = 0;
//         idx = 3
//          1 3 2 2

        while (!q.isEmpty()) {
            check();

            if (q.peek() == idx) {
                q.poll();
                cnt++;
                if (idx == location)
                    break;
            } else {
                q.offer(q.poll());
            }

        }


        return cnt;
    }
}

