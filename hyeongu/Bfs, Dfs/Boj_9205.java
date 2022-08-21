import java.io.*;
import java.util.*;

public class Boj_9205 {
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+2][2];
					
			for(int j = 0;j<N+2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			if(bfs(0)) {
				sb.append("happy").append("\n");
			}
			else {
				sb.append("sad").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N+2];
		
		q.offer(x);
		visit[x] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i<N+2; i++) {
				if(!visit[i]) {
					if(Math.abs(arr[now][0] - arr[i][0]) + Math.abs(arr[now][1] - arr[i][1]) <= 1000) {
						q.offer(i);
						visit[i] = true;
					}
				}
			}
			if(visit[N+1]) {
				return true;
			}
		}
		return false;
	}
}
