import java.io.*;
import java.util.*;

public class Day7_Maze1 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int T = 1; T<=10; T++) {
			int testcase = Integer.parseInt(br.readLine());
			arr = new int[16][16];
			visit = new boolean[16][16];
			int x = -1;
			int y = -1;
			
			for(int i = 0; i<16; i++) {
				String str = br.readLine();
				for(int j = 0; j<16; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if(arr[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}		
			sb.append("#").append(T).append(" ").append(bfs(x, y)).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int x , int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny <0 || nx>=16 || ny>= 16 || visit[nx][ny]) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
				if(arr[nx][ny] == 3) {
					return 1;
				}
			}
		}
		
		return 0;
	}
}
