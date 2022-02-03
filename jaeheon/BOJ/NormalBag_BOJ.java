package BOJ;

// 백준 평범한 배낭   12865

import java.io.*;
import java.util.*;

public class NormalBag_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 물품의 수
		int k = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[] answer = new int[k+1]; // 가치 배열
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken()); // 물건의 무게 
			int v = Integer.parseInt(st.nextToken()); // 해당 물건의 가치
			
			for(int j = k; j >= w; j--) {
				if(answer[j-w] + v > answer[j]) {
					answer[j] = answer[j-w] + v;
				}
			}
		}
		System.out.println(answer[k]);
	}
}
