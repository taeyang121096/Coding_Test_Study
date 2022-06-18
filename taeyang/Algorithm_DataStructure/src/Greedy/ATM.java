package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());

        int[] time = new int[n];
        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0;i<n;i++) time[i] = Integer.parseInt(st.nextToken());
//`     그리디 알고리즘 -> 값 작은걸로 만든거죠
        Arrays.sort(time);

        int sum = 0;

        for(int i = 0;i<n;i++){
            int s = 0;
            for(int j = 0;j<=i;j++){
                s += time[j];
            }
            sum += s;
        }

        System.out.println(sum);
    }
}
