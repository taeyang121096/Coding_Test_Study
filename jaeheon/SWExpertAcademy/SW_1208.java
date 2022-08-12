package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1208 {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		for(int T = 1; T <= 10; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < n; i++){
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            int answer = arr[99] - arr[0];
            sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
        System.out.println(sb.toString());
	}
}
