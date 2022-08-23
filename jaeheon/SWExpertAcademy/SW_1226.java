package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1226 {
	
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	static int a, b;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[16][16];
			visit = new boolean[16][16];
			for(int i = 0; i < 16; i++) {
				String str = br.readLine();
				for(int j = 0; j < 16; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			a = 0;
			b = 0;
			answer = 0;
			for(int i = 0 ; i < 16 ; i++) {
				for(int j = 0 ; j < 16 ; j++) {
					if (arr[i][j] == 2) {
						a = i;
						b = j;
						break;
					} else {
						continue;
					}
				}
			}
			dfs(a, b);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int r, int c) {
		if(answer == 1) {
			return;
		}
		if(arr[r][c] == 3) {
			answer = 1;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr < 0 || nc < 0 && nr >= 16 || nc >= 16 || visit[nr][nc] || arr[nr][nc] == 1) {
				continue;
			}
			if(arr[nr][nc] == 0 || arr[nr][nc] == 3) {
				visit[nr][nc] = true;
				dfs(nr, nc);
			}
		}
		
	}
}
