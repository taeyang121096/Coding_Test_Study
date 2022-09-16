import java.util.*;
import java.io.*;

public class Boj_1038 {
	static int[] arr;
	static int[] d = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static int r;
	static int cnt;
	static int N;
	static long answer = -1;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		r = 1;
		cnt = 0;
		
		while(r<=10) {
			cnt += combination(10,r);
			if(cnt-1 >= N) {
				break;
			}
			r++;
		}
		System.out.println(cnt);
		if(r == 11) {
			System.out.println(answer);
			return;
		}
		arr = new int[r];
		dfs(0, 10);
		
		System.out.println(answer);
	}

	static void dfs(int depth, int last) {
		if(answer>0) {
			return;
		}
		if(depth == r) {
			cnt--;
			if(cnt == N) {
				for(int i = 0; i<r ; i++) {
					sb.append(arr[i]);
				}
				answer = Long.parseLong(sb.toString());
			}
			return;
		}
		
		for(int i = last - 1; i>=0; i--) {
			arr[depth] = i;
			dfs(depth+1, i);
		}
	}
	static int combination(int n, int r) {
		if(n == r || r == 0) {
			return 1;
		}
		else {
			return combination(n-1, r-1) + combination(n-1, r);
		}
	}
}