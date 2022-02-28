
import java.util.*;
public class Warmingup_Pro {


    class Solution {
        //     n 한 심사대에서 한명 만 심사 가능
//     시간 최소
//     times : 걸리는 시간 n : 사람 수
//     n 1 ~ 1000,000,000 10억
//     times 1 ~ 100,000 10만 -> 1 ~ 10억 까지 시간이 걸릴 수 있다.
//     1. sorting 을 한다.
//     42 7 : 6 10 : 4 -> half 21 -> 7 : 3 10 :2
//
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long left = 1;
            long right = times[0] * n;
            long first = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                int cnt = 0;
                for (int t : times) {
                    cnt += mid / t;
                    if (cnt > n)
                        break;
                }
                if (cnt > n)
                    right = mid - 1;
                else if (cnt < n)
                    left = mid + 1;
                else {
                    first = mid;
                    break;
                }
            }

            long min = (long) times[0] * (first / (long) times[0]);
            int cnt = (int) (first / (long) times[0]);
            while (min <= first) {
                int f = cnt;
                boolean flag = false;
                for (int i = 1; i < times.length; i++) {
                    f += min / times[i];
                    if (f >= n) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
                min++;
            }
            answer = min;
            return answer;
        }
    }
}
