package BOJ;

// 백준 2750 수 정렬하기 

import java.io.*;
import java.util.*;

public class NumSort_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// Wrapper 클래스 : 기본형을 객체처럼 사용하고 싶을때
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append("\n");
		}
		
//		for(int i : arr) {
//			sb.append(i).append('\n');
//		}
		System.out.println(sb);
	}

}
