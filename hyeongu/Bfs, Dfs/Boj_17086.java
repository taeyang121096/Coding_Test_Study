import java.io.*;
import java.util.*;

public class Boj_17086 {
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[][] arr;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i<N; i++) {
			Arrays.fill(arr[i], 50);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					bfs(i, j);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j< M; j++) {
				if(answer <= arr[i][j]) {
					answer = arr[i][j];
				}
			}
		}
		System.out.println(answer);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		arr[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i<8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny <0 || nx>=N || ny>= M) {
					continue;
				}
				if(!visit[nx][ny] && arr[nx][ny] > arr[now[0]][now[1]] + 1) {
					q.add(new int[] {nx, ny});
					visit[nx][ny] = true;
					arr[nx][ny] = arr[now[0]][now[1]] + 1;
				}
			}
		}
		
	}
}
