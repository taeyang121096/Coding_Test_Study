package BOJ;

// 백준 최소, 최대 10818
// n : 정수의 개수  N (1 ≤ N ≤ 1,000,000)
// n개의 정수를 공백으로 구분해서 준다
// return : 최소 최대를 공백으로 구분해서 출력

import java.io.*;
import java.util.*;

public class MinAndMax_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[0] + " " + arr[n-1]);
	}
}
