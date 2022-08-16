package BOJ;

// 백준 1303 전쟁-전투
// 뭉쳐있으면 n^2의 위력
// 내 병사가 흰색

import java.util.*;
import java.io.*;

public class Combat_BOJ {
	
	static char[][] mat;
	static boolean[][] visit;
	static int n;
	static int m;
	static int white = 0;
	static int blue = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mat = new char[m][n];
		visit = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				mat[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j] && mat[i][j] == 'W') {
					visit[i][j] = true;
					bfs(i, j, 'W');
				}
				if(!visit[i][j] && mat[i][j] == 'B') {
					visit[i][j] = true;
					bfs(i, j, 'B');
				}
			}
		}
		System.out.println(white + " " + blue);
	}

	static void bfs(int r, int c, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			cnt++;
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= m || nc >= n || visit[nr][nc]) {
					continue;
				}
				if(color == mat[nr][nc]) {
					visit[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		if(color == 'W') {
			white += Math.pow(cnt, 2);
		}else if(color == 'B') {
			blue += Math.pow(cnt, 2);
		}
	}
}
