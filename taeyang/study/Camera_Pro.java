import java.util.*;

public class Camera_Pro {

    //     시작점 오름 차순
//     끝나는점 오름 차순
//     -20       -15
//          -18        -13
//                  -14        -5
//                             -5    -3
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        int e = -30001;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > e) {
                answer++;
                e = routes[i][1];
            }
        }


        return answer;
    }
}

