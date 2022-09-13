import java.io.*;
import java.util.*;

public class Boj_15686 {
	static boolean[] visit;
	static int[] choice;
	static int[][] arr;
	static List<int[]>al = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int [N+1][N+1];
		choice = new int[M];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					arr[i][j] = 0;
					al.add(new int[] {i, j});
				}
			}
		}
		visit = new boolean[al.size()];
		combination(al.size(), M, 0, 0);
		System.out.println(min);
	}
	
	static void combination(int n, int r, int start, int depth) {
		if(depth == r) {
			min = Math.min(bfs(choice), min);
			return;
		}
		for(int i = start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				choice[depth] = i;
				combination(n, r, i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}
	
	static int bfs(int[] choice) {
		
		int[][]map = new int[N+1][N+1];
		
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				map[i][j] = arr[i][j];
			}
		}
		
		Queue<int[]>q = new LinkedList<>();
		boolean[][] isvisit = new boolean[N+1][N+1];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int count = 0;
		
		for(int i = 0; i<choice.length; i++) {
			int[] tmp = al.get(choice[i]);
			q.offer(tmp);
			isvisit[tmp[0]][tmp[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<1 || ny <1 || nx>N || ny>N || isvisit[nx][ny]) {
					continue;
				}
				if(map[nx][ny] == 1) {
					count += map[now[0]][now[1]] + 1;
				}
				q.offer(new int[] {nx, ny});
				isvisit[nx][ny] = true;
				map[nx][ny] = map[now[0]][now[1]] + 1;
			}
		}
		return count;
	}
}