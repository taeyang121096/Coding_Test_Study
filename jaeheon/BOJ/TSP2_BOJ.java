package BOJ;

// 백준 10971 외판원순회2 Traveling Salesman problem (TSP) 
// 한 도시에서 출발해서 n개의 도시를 거쳐 원래 도시로 돌아오는 경로
// 한번 갔던 도시는 방문 못함
// W[i][j] -> 도시 i에서 j로 가기 위한 비용 대칭적이지 않음
// 최소 비용 리턴

import java.util.*;
import java.io.*;

public class TSP2_BOJ {

	static int n;
	static int[][] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			visit = new boolean[n];
			visit[i] = true;
			dfs(i, i, 0);
		}
		System.out.println(min);
	}

	static void dfs(int start, int end, int cost) {
		if(check()) { 
			if(arr[start][end] != 0) {
				cost += arr[start][end];
				min = Math.min(min, cost);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (arr[start][i] != 0 && !visit[i]) {
				visit[i] = true;
				dfs(i, end, cost + arr[start][i]);
				visit[i] = false;
			}
		}

	}

	static boolean check() {
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
	}
}
