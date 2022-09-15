import java.io.*;
import java.util.*;

public class Boj_2589 {
	static int N;
	static int M;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		int answer = 0;
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(arr[i][j] == 'L') {
					answer = Math.max(bfs(i, j, 0), answer);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static int bfs(int x, int y, int d) {
		Queue<int[]>q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		int res = 0;
		
		q.offer(new int[] {x, y, d});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				res = Math.max(res, now[2]);
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == 'W') {
					continue;
				}
				q.offer(new int[] {nx, ny, now[2] + 1});
				visit[nx][ny] = true;
			}
		}
		return res;
	}
}