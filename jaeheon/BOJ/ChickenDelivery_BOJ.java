package BOJ;
// 도시의 칸은 (r, c)와 같은 형태, r,c는 1부터 시작

// 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리 |r1-r2| + |c1-c2|
// 도시의 치킨 거리 : 모든 집의 치킨 거리의 합
// 결과 : 도시의 치킨 거리의 최소값
// 0은 빈 칸, 1은 집, 2는 치킨집이다.
// m개 고르고 나머지 폐업

import java.io.*;
import java.util.*;

public class ChickenDelivery_BOJ {
	
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static int[] choice;
	static int n;
	static int m;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 도시의 크기
		m = Integer.parseInt(st.nextToken()); // 치킨집 개수

		int[][] arr = new int[n][n]; // 도시
		choice = new int[m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					house.add(new int[] {i, j});
				}
				if (arr[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	}

	static void dfs(int depth, int at) {
		if(depth == m) {
			int tmp = 0;
			for(int i = 0; i < house.size(); i++) {
				int distance = Integer.MAX_VALUE;
				for(int j = 0; j < choice.length; j++) {
					distance = Math.min(Math.abs(chicken.get(choice[j])[0] - house.get(i)[0]) + Math.abs(chicken.get(choice[j])[1] - house.get(i)[1]), distance);
				}
				tmp += distance;
			}

			answer = Math.min(tmp, answer);
			return;
		}
		
		for(int i = at; i < chicken.size(); i++) {
			choice[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}
}
