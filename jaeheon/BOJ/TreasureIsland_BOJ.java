package BOJ;

// L : 육지 W : 바다
// 이동은 상하좌우로 육지로만
// 한칸 이동하는데 한시간
// 보물 : 서로 간에 최단거리로 이동하는데 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 있음
// 최단거리로 이동 : 같은 곳을 두번 이상 지나가거나 멀리 돌아가면 안됨


import java.io.*;
import java.util.*;

public class TreasureIsland_BOJ {
	static int n;
	static int m;
	static int answer = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static char[][] mat;
	static int[][] arr;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		mat = new char[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				mat[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	static void bfs(int r, int c) {
		visit = new boolean[n][m];
		arr = new int[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dx[i];
				int nc = now[1] + dy[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || visit[nr][nc]) {
					continue;
				}
				
				if(mat[nr][nc] == 'L') {
					q.offer(new int[] {nr, nc});
					visit[nr][nc] = true;
					arr[nr][nc] = arr[now[0]][now[1]] + 1;
					answer = Math.max(answer, arr[nr][nc]);
				}
			}
		}
	}
}
