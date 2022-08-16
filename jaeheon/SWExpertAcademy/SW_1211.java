package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class SW_1211 {
	
	static int[][] mat;
	static boolean[][] visit;
	static int[] dx = {0, 0, 1};
	static int[] dy = {-1, 1, 0};
	static int answer = 0;
	static int distance;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int T = 1; T <= 10; T++) {
			int tc = Integer.parseInt(br.readLine());
			mat = new int[100][100];
			List<Integer> al = new ArrayList<>();
			distance =Integer.MAX_VALUE;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 && mat[0][j] == 1) {
						al.add(j);
					}
				}
			}
			
			for(int i = 0; i < al.size(); i++) {
				int cnt = 0;
				int tmp = al.get(i);
				visit = new boolean[100][100];
				dfs(0, tmp, cnt, tmp);
			}
			
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int r, int c, int cnt, int start) {
		visit[r][c] = true;
		if (r == 99) {
			if(distance >= cnt) {
				distance = cnt;
				answer = start;
				return;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr < 0 || nc < 0 || nr >= 100 || nc >= 100 || mat[nr][nc] == 0 || visit[nr][nc]) {
				continue;
			}
			
			if (nr >= 0 && nc >= 0 && nr < 100 && nc < 100 && mat[nr][nc] == 1 && !visit[nr][nc]) {
				dfs(nr, nc, cnt+1, start);
				break;
			}
		}

	}
}
