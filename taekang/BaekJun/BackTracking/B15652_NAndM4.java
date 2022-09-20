package BaekJun.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class B15652_NAndM4 {

    static Integer N, M;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        find(N, M, 0, 1);
    }

    /**
     * find(4,2,0,1), arr[0] = 1 -> find(4,2,1,1), arr[1] = 1 & find(4,2,0,2)
     * find(4,2,2,1) -> return {1,1} & 이어 받아서 find(4,2,1,2) arr[1] = 2
     * find(4,2,2,2) -> return {1,2} & 이어 받아서 find(4,2,1,3) arr[1] = 3
     * find(4,2,2,3) -> return {1,3} & 이어 받아서 find(4,2,1,4) arr[1] = 4
     * find(4,2,2,4) -> return {1,4} & 이어 받아서 find(4,2,1,5) index > N return;
     *
     * 그럼 이제부턴 find(4,2,0,2) 시작!!
     */

    public static void find(Integer N, Integer M, Integer select, Integer index) {
        if (M == select) {
            for(int in : arr){
                System.out.print(in+" ");
            }
            System.out.println();
            return;
        }

        if (index > N) {
            return;
        }

        // 선택이 되는 경우
        arr[select] = index;
        find(N, M, select + 1, index);

        // 선택이 되지 않는 경우
        find(N, M, select, index + 1);
    }
}
