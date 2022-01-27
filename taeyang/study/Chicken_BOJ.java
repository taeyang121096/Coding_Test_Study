
// 빈칸 0 , 치킨집2 집1 중 하나 (r,c)
// 치킨 거리 = 집과 가장 가까운 치킨집 사이의 거리
// 도시의 치킨 거리 = 모든 집의 치킨 거리의 합
// (r1,c1) 과 (r2,c2 ) 사이의 거리는 |r1-r2| + |c1-c2| 이다

// bfs 사용 최소 값 찾기
// 조합 사용 치킨집 가져오기

import java.io.*;
import java.util.*;


public class Chicken_BOJ {
    //    loc 기존에 있던 치킨 집의 row col ,  5개 0~4
    static List<int[]> loc = new ArrayList<>();
    //    그 조합 이게 loc 의 인덱스 번호의 조합이지    0 1 2,   2 1 3,   324,

    static int[][] origin;
    static List<int[]> person = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static int n;
    static int cnt;
//(0,1), (4,4)
    static void combi(int level, int m, int start, int[] tmp) {
        if (level == m) {
            cnt = 0;
            for(int[] p : person){
                int val = Integer.MAX_VALUE;
                for(int idx : tmp){
                    val = Math.min(val,Math.abs(p[0]-loc.get(idx)[0]) +Math.abs(p[1]-loc.get(idx)[1]));
                }
                cnt+=val;
            }
            min = Math.min(min,cnt);
            return;
        }
        for (int i = start; i < loc.size(); i++) {
            tmp[level] = i;
            combi(level + 1, m, i + 1, tmp);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        origin = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int index = 0;
            while (st.hasMoreTokens()) {
                origin[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (origin[i][j] == 2)
                    loc.add(new int[]{i, j});

                if(origin[i][j] == 1)
                    person.add(new int[]{i,j});
            }
        }
        combi(0, m, 0, new int[m]);

        System.out.println(min);


    }


}
