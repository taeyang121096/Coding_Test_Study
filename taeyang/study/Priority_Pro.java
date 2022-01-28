import java.util.*;

public class Priority_Pro {


    //
//     | 숫자 넣는다
//     D 1 큐에서 최댓값을 삭제 한다.
//     D -1 큐에서 최솟값을 삭제 한다.
//     1 ~ 1,000,000
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
//         낮은값 부터  1 2 3 4
        PriorityQueue<Integer> lq = new PriorityQueue<>();
//         높은 값 부터  4  3 2 1
        PriorityQueue<Integer> hq = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : operations) {
            char op = str.split(" ")[0].charAt(0);
            int val = Integer.parseInt(str.split(" ")[1]);

            if (op == 'I') {
                lq.offer(val);
                hq.offer(val);
            } else {
                if (hq.size() == 0)
                    continue;

                if (val == 1) {
                    int max = hq.poll();
                    lq.remove(max);
                } else {
                    int min = lq.poll();
                    hq.remove(min);
                }
            }

        }
        if (hq.size() > 0) {
            answer[0] = hq.poll();
            answer[1] = lq.poll();
        }

        return answer;
    }
}

