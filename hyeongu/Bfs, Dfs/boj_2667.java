import java.util.*;
import java.io.*;
public class boj_2667 {
	
	static boolean[][] isVisit;
	static int[][] map;
	static int N;
	static int cnt = 0;
	
	static void dfs(int x, int y) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		isVisit[x][y] = true;
		
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&ny>=0&&nx<N&&ny<N) {
				if(!isVisit[nx][ny]&&map[nx][ny]==1) {
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		map = new int[N][N];
		isVisit = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!isVisit[i][j]&&map[i][j]==1) {
					cnt = 1;
					dfs(i, j);
					arr.add(cnt);
					cnt = 1;
				}
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for(int i = 0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}