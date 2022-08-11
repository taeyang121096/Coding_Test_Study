package BOJ;

// 백준 2559 수열

import java.util.*;
import java.io.*;

public class Progression_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n - k; i++) {
			int sum = 0;
			for(int j = i; j < i+k; j++) {
				sum += arr[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
