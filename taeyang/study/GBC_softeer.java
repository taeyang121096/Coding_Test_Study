import java.util.*;
import java.io.*;

public class GBC_softeer {


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] origin = new int[n][3];
        int val = 0;
        //
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            origin[i][0] = val;
            origin[i][1] = val + Integer.parseInt(st.nextToken());
            origin[i][2] = Integer.parseInt(st.nextToken());
            val = origin[i][1];
        }
        int start = 0;

        // 0 ~ 50, 50 ~ 90, 90 ~ 100
        //   50       40       30
        // 0 ~ 60, 60 ~ 78, 78 ~ 100
        //  76        28       50
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            for (int[] o : origin) {
                if (start < o[1] && start + first > o[0]) {

                    if (o[2] < second) {
                        // System.out.println(o[0]+" ~ "+ o[1]+" "+ start+" ~ "+(start+first));
                        max = Math.max(max, second - o[2]);
                    }
                }
            }
            start += first;
        }

        System.out.println(max);

    }
}

