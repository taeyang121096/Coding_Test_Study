package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] tmp = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<n;i++) tmp[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        int left = 0;
        int right = k;

        int ans = 0;

        for(int i = 0;i<right;i++){
            sum += tmp[i];
        }
        ans = sum;
//        슬라이딩 윈도우
        while(right < n){
            sum -= tmp[left++];
            sum += tmp[right++];

            ans = Math.max(sum,ans);
        }
        System.out.println(ans);



    }
}
