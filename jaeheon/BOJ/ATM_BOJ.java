package BOJ;

// 백준 11399 ATM

import java.util.*;
import java.io.*;

public class ATM_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		// 1
		// 1 + 2 = 3
		// 1 + 2 + 3 = 6
		// 1 + 2 + 3 + 3 = 9
		// 1 + 2 + 3 + 3 + 4 = 13
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int answer = 0;
		int cnt = arr.length;
		for(int i = 0; i < arr.length; i++) {
			answer += arr[i]*cnt;
			cnt--;
		}
		
//		int tmp = 0;
//		int answer = 0;
//		for(int i = 0; i < n; i++) {
//			tmp += arr[i];
//			answer += tmp;
//		}
		
		System.out.println(answer);
	}
}
