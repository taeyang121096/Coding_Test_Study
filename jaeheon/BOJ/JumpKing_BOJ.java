package BOJ;

// 백준 16713 점프왕 쩰리

// 게임 구역의 크기 2~3
// 게임 구역은 정사각형
// 게임판 승리지점에는 -1 있음
// 쩰리는 아래와 오른쪽으로만 이동 가능

import java.io.*;
import java.util.*;

public class JumpKing_BOJ {
	
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	static boolean[][] visit;
	static int[][] arr;
	static int n;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[0][0] = true;
		dfs(0, 0);
		
		if(answer == 0) {
			System.out.println("Hing");
		} else {
			System.out.println("HaruHaru");
		}
	}
	
	static void dfs(int r, int c) {
		int move = arr[r][c];
		for(int i = 0; i < 2; i++) {
			int nr = r + dr[i]*move;
			int nc = c + dc[i]*move;
			
			if ( nr >= n || nc >= n || visit[nr][nc] ) {
				continue;
			}
			if(arr[nr][nc] == -1) {
				answer = -1;
				return;
			}
			visit[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
