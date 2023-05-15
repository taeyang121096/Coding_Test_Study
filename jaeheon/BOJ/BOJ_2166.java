package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                } else if(o1[0] < o2[0]){
                    return -1;
                } else {
                    if(o1[1] > o2[1]){
                        return 1;
                    } else if(o1[1] < o2[1]){
                        return -1;
                    } else{
                        return 0;
                    }
                }
            }
        });

        long answer = 0;
        int cnt = 0;
        for(int i = 0; i < n-2; i++){
            int ax = arr[i][0];
            int ay = arr[i][1];
            int bx = arr[i+1][0];
            int by = arr[i+1][1];
            int cx = arr[i+2][0];
            int cy = arr[i+2][1];
            long res = (Math.abs(ax*by + bx*cy + cx*ay - ax*cy - cx*by - bx*ay));
            if(res % 2 == 1){
                cnt++;
            }
            answer += res/2;
        }
        double tmp = cnt*0.5;

        String str = String.valueOf(tmp);
        String str1 = String.valueOf(answer);
        int strlen = str.length() - 2;
        int str1len = str1.length();

        str1 = str1.substring(0, str1len-strlen);
        str1+=str;
        System.out.println(str1);
    }
}
