package BaekJun.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651_NAndM3 {
    static Integer N, M;
    static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        find(N, M, 0);
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    // find(4,2,0)

    public static void find(Integer N, Integer M, Integer index) {
        // 종료조건을 먼저 생각을해라
        if (M == index) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        if (index > N) {
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            arr[index] = i;
            find(N, M, index + 1);
        }
    }
}


