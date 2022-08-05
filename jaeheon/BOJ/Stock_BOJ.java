package BOJ;

// 백준 11501 주식

import java.util.*;
import java.io.*;

public class Stock_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] stockPrice = new int[n];
			for(int j = 0; j < n; j++) {
				stockPrice[j] = Integer.parseInt(st.nextToken());
			}
			long answer = 0;
			long max = 0;
			for(int j = n-1; j >= 0; j--) {
				if(max < stockPrice[j]) {
					max = stockPrice[j];
				} else {
					answer += max - stockPrice[j];
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
