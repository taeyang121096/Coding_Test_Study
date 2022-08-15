package BOJ;

// 백준 4963 섬의개수

import java.util.*;
import java.io.*;

public class NumberOfIsland_BOJ {
	
	static int w;
	static int h;
	static int[][] mat;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			mat = new int[h][w];
			visit = new boolean[h][w];
			
			if(w == 0 && h == 0) {
				break;
			}
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(mat[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		visit[r][c] = true;
		for(int i = 0; i < 8; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr < 0 || nc < 0 || nr >= h || nc >= w) {
				continue;
			}
			if(nr >= 0 && nc >= 0 && nr < h && nc < w && !visit[nr][nc] && mat[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
