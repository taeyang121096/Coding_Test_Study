package basic;

import java.io.*;
import java.util.*;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<n;i++)
            time[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(time);
        int sum = 0;
        int ans = 0;
        for(int i : time) {
            sum += i;
            ans += sum;
        }
        System.out.println(ans);
    }
}
