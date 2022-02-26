package BOJ;
//백준 1920 수 찾기
import java.util.*;
import java.io.*;

public class FindNum_BOJ {
	
	static boolean binarySearch(int[] A, int target, int left, int right) {
		while(left <= right) {
			int mid = (left + right) / 2;
			if(A[mid] == target) {
				return true;
			} 
			
			if(A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 1 2 3 4 5
						// 1 3 7 9 5
		
		int k = Integer.parseInt(br.readLine());
		int[] M = new int[k];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < k; i++) {
			M[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < k; i++) {
			if(binarySearch(A, M[i], 0, n-1)) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
		
	}
}
