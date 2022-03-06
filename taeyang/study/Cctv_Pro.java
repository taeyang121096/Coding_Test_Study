import java.util.*;
public class Cctv_Pro {

    class Solution {
        //     한번은 만난다.
//     최소 몇대 의 카메라를 설치
//     차는 1 ~ 1만대
//     0 진입 1 나가는 시점
//     진입 시점 -3만 ~ 3만
//     -20                       -3
//     -20, -3,   (-14 -5) (-18 -13)
//     -20   -18  -14  -13  -5 -3
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes,new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int [] o2){
                    return o1[1]>o2[1] ? 1:-1;
                }
            });
            int first = -30001;
            for(int[] r : routes){
                if(r[0] > first){
                    first = r[1];
                    answer++;
                }
            }

            return answer;
        }
    }
}
