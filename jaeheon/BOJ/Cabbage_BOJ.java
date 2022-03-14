package BOJ;

//백준 1012 유기농배추

import java.util.*;
import java.io.*;

public class Cabbage_BOJ {
	
	static int M;
	static int N;
	static int K;
	
	static int[][] mat;
	static boolean[][] visit;
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추 개수
			
			mat = new int[M][N];
			visit = new boolean[M][N];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				mat[x][y] = 1;
			}
			
			int bug = 0;
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(mat[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						bug++;
					}
				}
			}
			System.out.println(bug);
		}
		
	}

	static void dfs(int row, int col) {
		visit[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < M && nc < N) {
				if(mat[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
		
	}
}
