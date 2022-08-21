import java.io.*;
import java.util.*;

public class Boj_7576 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	static int N;
	static int M;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp != 0) {
					arr[i][j] = tmp;
					if(tmp == 1) {
						q.add(new int[] {i, j});
						visit[i][j] = true;
						arr[i][j] = 0;
					}
				}
			}
		}
		
		bfs();
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(answer == -1) break;
			
			for(int j = 0; j< M; j++) {
				if(arr[i][j] == Integer.MAX_VALUE) {
					answer = -1;
					break;
				}
				else if(arr[i][j]>0) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
		}
		System.out.println(answer);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny <0 || nx>=N || ny>= M || visit[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == -1) {
					continue;
				}
				if(arr[nx][ny] > arr[now[0]][now[1]] + 1) {
					q.add(new int[] {nx, ny});
					visit[nx][ny] = true;
					arr[nx][ny] = arr[now[0]][now[1]] + 1;
				}
			}
		}
	}
}
