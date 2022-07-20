package BOJ;

// 백준 2805 나무자르기
// 나무의 수 : 1 ~ 백만
// 나무의 길이 : 1 ~ 20억
// 나무 높이의 최대 : 10억
// 출력 : m미터의 나무를 얻기 위해 설정할 절단기 높이의 최대값

import java.io.*;
import java.util.*;

public class TreeCut_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		
		long left = 0;
		long right = tree[n-1];
		long mid;
		
		while(right >= left) {
			mid = (left + right) / 2; // 절단기 높이
			long sum = 0; // 나무의 합
			for(int i = 0; i < tree.length; i++) {
				if(tree[i] - mid > 0) { // 자를수 있다면
					sum += tree[i] - mid; // 그만큼 합에 더함
				} else {
					continue;
				}
			}
			if(m > sum) { // 너무 안자름
				right = mid - 1; // 절단기 높이 낮춤
			} else { // 너무 많이 자름
				left = mid + 1; // 절단기 높이 높임
			}
		}
		System.out.println(right); // 절단기 높이의 최대값 : right
	}
}
