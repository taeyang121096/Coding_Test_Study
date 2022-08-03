package BOJ;

// 백준 11047 동전0

import java.util.*;
import java.io.*;

public class Coin0_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(k >= coin[i]) {
				answer += (k/coin[i]);
				k = k % coin[i];
			}
		}
		System.out.println(answer);
	}
}
