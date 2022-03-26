package BOJ;

import java.io.*;
import java.util.*;

// 백준 1427 소트 인사이드

// 수가 주어지면 내림차순으로 정렬

public class SortInside_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String str = String.valueOf(n);
		
		Integer[] arr = new Integer[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			arr[i] = Character.getNumericValue(str.charAt(i));
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
