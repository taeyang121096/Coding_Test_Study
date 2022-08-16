import java.util.*;
import java.io.*;
public class Day2_Ladder1 {
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i<=10; i++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	arr = new int[100][100];
        	visit = new boolean[100][100];
        	
        	int start = -1;
        	for(int j = 0; j<100; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int k = 0; k<100; k++) {
        			arr[j][k] = Integer.parseInt(st.nextToken());
        			if(arr[j][k] == 2) {
        				start = k;
        			}
        		}
        	}
        	dfs(99, start);
        	sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		if(x == 0) {
			answer = y;
			return;
		}
		visit[x][y] = true;
		
		for(int i = 0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0||ny<0||nx>=100||ny>=100) {
				continue;
			}
			if(arr[nx][ny] == 1&&!visit[nx][ny]) {
				dfs(nx, ny);
				return;
			}
		}
	}
}