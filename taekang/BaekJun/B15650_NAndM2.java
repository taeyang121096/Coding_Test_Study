package BaekJun;

import java.io.*;
import java.util.StringTokenizer;

public class B15650_NAndM2 {

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
        find(N, M, select + 1, index + 1);

        // 선택이 되지 않는 경우
        find(N, M, select, index + 1);
    }
}
