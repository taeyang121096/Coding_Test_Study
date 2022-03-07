package BOJ;

//백준 1010 다리놓기

//조합 문제

import java.util.*;
import java.io.*;

public class PutBridge_BOJ {
	static double comb(double r, double n) {
		double left = 1;
		double right = 1;
		
		for(double i = n; i > n-r; i--) {
			right = right*i;
		}
		
		for(double i = r; i > 0; i--) {
			left = left*i;
		}
		
		return right/left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			System.out.printf("%.0f\n", comb(left, right));
		}
	}
}
