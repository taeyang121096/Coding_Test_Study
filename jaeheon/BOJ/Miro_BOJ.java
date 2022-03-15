package BOJ;

import java.util.*;
import java.io.*;

public class Miro_BOJ {

	static int N;
	static int M;

	static int[][] mat;
	static boolean[][] visit;

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		mat = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				mat[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		bfs(0, 0);
		System.out.println(mat[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		
		Queue<Integer> qx = new LinkedList<>(); 
		Queue<Integer> qy = new LinkedList<>();
		
		qx.add(x);
		qy.add(y);

		while (!qx.isEmpty() && !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			
			visit[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (visit[nr][nc] == false && mat[nr][nc] == 1) {
						qx.add(nr);
						qy.add(nc);
						visit[nr][nc] = true;
						mat[nr][nc] = mat[x][y] + 1;
					}
				}
			}
		}
	}
}
