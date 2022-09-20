package BaekJun.Greedy;

import java.io.*;
import java.util.*;

/**
 * 서류심사 성적과 면접시험 성적이 떨어지지않는 자만 선발한다
 */
public class B1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 5
            int[][] map = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                map[j][0] = Integer.parseInt(str[0]);
                map[j][1] = Integer.parseInt(str[1]);
            }
            // 그니까 둘 중 하나는 낮아도 되는데, 둘다 낮으면 안된다 이말이지

            Arrays.sort(map, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // 끝 기준으로 정렬
                    if(o1[0] < o2[0])
                        return -1;
                    return 1;
                }
            });
//            int answer = 0;
//            for (int j = 0; j < N; j++) {
//                boolean flag = true;
//                for (int k = 0; k < N; k++) {
//                    if(j != k){
//                        if(map[j][1] < map[k][1])
//                            flag = false;
//                            break;
//                    }
//                }
//                if(flag)    answer++;
//            }
            int answer = 1;
            int interview = map[0][1]; // 면접 점수
            for (int j = 1; j < N; j++) {
                if(map[j][1] < interview){
                    answer++;
                    interview = map[j][1];
                }
            }
            System.out.println(answer);

//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < 2; k++) {
//                    System.out.print(map[j][k] + " ");
//                }
//                System.out.println();
//            }
        }
    }
}
