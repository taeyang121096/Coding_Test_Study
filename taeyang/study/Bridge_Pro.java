import java.util.*;

public class Bridge_Pro {

//     length대 올라갈 수 있다 1 ~ 10,000
//     weight 이하 까지 무게 견딤 1 ~ 10,000
//     truck 1 ~ 10,000

    //     큐 문제이다.
//     1 7, 2 7
//
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        int time = 0;
        int idx = 0;
        int w = 0;
//         시간 순으로 빼줘야 한다.
        while (cnt < truck_weights.length) {
            time++;
            if (q.size() == bridge_length) {
                int val = q.poll();
                if (val != 0)
                    cnt++;
                w -= val;
            }
            if (idx < truck_weights.length && w + truck_weights[idx] <= weight) {
                w += truck_weights[idx];
                q.offer(truck_weights[idx++]);
            } else {
                q.offer(0);
            }

        }
        answer = time;
        return answer;
    }
}

