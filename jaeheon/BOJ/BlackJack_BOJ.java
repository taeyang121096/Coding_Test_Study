package BOJ;

import java.io.*;
import java.util.*;

public class BlackJack_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;

		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					if(sum < num[i] + num[j] + num[k]){
						if(M >= num[i] + num[j] + num[k]) {
							sum = num[i] + num[j] + num[k];
						}
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
