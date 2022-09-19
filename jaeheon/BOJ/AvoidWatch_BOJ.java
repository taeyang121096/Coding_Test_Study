package BOJ;

import java.util.*;
import java.io.*;

public class AvoidWatch_BOJ {

	static int n;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static String[][] mat;
	static List<int[]> t = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		mat = new String[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				mat[i][j] = st.nextToken();
				if (mat[i][j].equals("T")) {
					t.add(new int[] { i, j });
				}
			}
		}
		dfs(0);
		System.out.println("NO");
	}

	static void dfs(int depth) {
		if (depth == 3) {
			if (check()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j].equals("X")) {
					mat[i][j] = "O";
					dfs(depth + 1);
					mat[i][j] = "X";
				}
			}
		}
	}

	static boolean check() {
		for (int i = 0; i < t.size(); i++) {
			int[] tmp = t.get(i);
			for (int j = 0; j < 4; j++) {
				int nr = tmp[0];
				int nc = tmp[1];
				while (true) {
					nr += dx[j];
					nc += dy[j];

					if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
						break;
					}
					if (mat[nr][nc].equals("O")) {
						break;
					}
					if (mat[nr][nc].equals("S")) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
