package BOJ;

// 백준 15661 링크와 스타트

// Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치
// n : 4 ~ 20
// 스타트 팀과 링크 팀의 능력치의 차이의 최솟값

import java.util.*;
import java.io.*;

public class LinkAndStart_BOJ {
	
	static int n;
	static int[][] mat;
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		mat = new int[n][n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t = 1; t <= n/2; t++) {
			dfs(0, 0, t);
		}
		
		System.out.println(answer);
	}

	static void dfs(int depth, int at, int t) {
		if(depth == t) {
			cal();
			return;
		}
		
		for(int i = at; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(depth + 1, i + 1, t);
				visit[i] = false;
			}
		}
	}

	static void cal() {
		int linkTeam = 0;
		int startTeam = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(visit[i] != visit[j]) {
					continue;
				}
				if(visit[i] && visit[j]) {
					linkTeam += mat[i][j];
					linkTeam += mat[j][i];
				} else if(!visit[i] && !visit[j]) {
					startTeam += mat[i][j];
					startTeam += mat[j][i];
				}
			}
		}
		answer = Math.min(answer, Math.abs(linkTeam - startTeam));
	}
}
