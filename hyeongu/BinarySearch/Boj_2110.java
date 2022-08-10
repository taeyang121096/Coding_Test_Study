// n <= 200000, c<n, 좌표 <10억
// 한 집에는 하나의 공유기만 설치 가능
// 각각의 공유기 사이의 거리가 최대가 되는 경우를 출력

import java.io.*;
import java.util.*;

public class Boj_2110 {
	public static int[] arr; 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int left = 1;
		int right = arr[N-1] - arr[0];
		int answer = 0;
		
		while(left<=right) {
			int router = 1;
			int mid = (left + right) / 2;
			int prev = arr[0];
			
			for(int i = 1; i< N; i++) {
				if(arr[i] - prev >= mid) {
					router++;
					prev = arr[i];
				}
			}
			if(router >= C) {
				left = mid + 1;
				answer = mid;
			}
			else {
				right = mid -1;
			}
		}
		System.out.println(answer);
	}	
}