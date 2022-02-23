import java.util.*;

public class Bridge_KaKao {


//
//    디딤돌 숫자 한 번 밝으면 -1
//     숫자 0 더이상 못 밝음 -> 그 다음 디딤돌로 한번에 여러칸
//     가장 가까운 디딤돌
//     한번에 한명씩 징검다리를 건넌다
//     k -> 한번에 뛸 수 있는 최대 값
//     return 최대 몇명 건널 수 있냐
//     친구 무한
//     stone 1 ~ 200 000
//     원소 값은 int 값
//     2 4 5, 4 5 3, 5 3 2 , 3 2 1

    static boolean check(int val) {
        int empty = 0;

        for (int stone : S) {
            if (stone - val < 0) {
                empty++;
            } else {
                empty = 0;
            }
            if (empty == K)
                return false;
        }
        return true;
    }

    static int[] S;
    static int K;

    public int solution(int[] stones, int k) {
        int answer = 0;

        S = stones;
        K = k;
        int left = 1;
        int right = 200000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                right = mid - 1;
            }

        }


        return answer;
    }
}

