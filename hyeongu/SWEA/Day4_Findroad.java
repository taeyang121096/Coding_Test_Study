import java.io.*;
import java.util.*;

public class Day4_Findroad {
	static int[][] arr;
	static int N;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int T = 1; T <= 10; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int testcase = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new int[100][100];
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			dfs(0);
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int n) {
		if(n == 99) {
			answer = 1;
			return;
		}
		
		for(int i = 0; i<100; i++) {
			if(arr[n][i] == 1) {
				arr[n][i] = 0;
				dfs(i);
			}
		}
	}
}
