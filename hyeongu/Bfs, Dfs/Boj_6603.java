import java.util.*;
import java.io.*;
public class Boj_6603 {
	static boolean[] visit;
	static int[] arr;
	static int[] answer;
	static int N;
	static StringBuilder sb= new StringBuilder();
	static void dfs(int start, int depth) {
		if(depth == 6) {
			for(int i = 0; i<6; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i<N; i++) {
				visit[i] = true;
				answer[depth] = arr[i];
				dfs(i+1, depth + 1);
				visit[i] = false;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			visit = new boolean[N];
			answer = new int[6];
			arr = new int[N];
			
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}