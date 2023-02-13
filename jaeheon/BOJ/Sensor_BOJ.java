package BOJ;

import java.util.*;
import java.io.*;

public class Sensor_BOJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        if(k >= n){
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1 3 6 6 7 9
        // 2 3 0 1 2
        // 0 1 2 2 3

        // 3 6 7 8 10 12 14 15 18 20

        Arrays.sort(arr);

        int[] dis = new int[n-1];
        for(int i = 0; i < n-1; i++){
            dis[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(dis);
        int answer = 0;
        for(int i = 0; i < n - k; i++){
            answer += dis[i];
        }
        System.out.println(answer);
    }
}
