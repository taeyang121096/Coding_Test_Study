import java.util.*;
import java.io.*;
// 도착한 배열의 값 만큼 오른쪽 또는 아래쪽으로 이동
// (N,N)에 도달할 수 있을 때 승리
public class boj_16173 {
	public static int[][] map;
	public static int N;
	public static boolean check = false;
	public static void dfs(int x, int y) {
		if(x>N||y>N) return;
		if(x==N&&y==N) {
			check = true;
			return;
		}
		if(!check&&map[x][y]>0){
			dfs(x+map[x][y], y);
			dfs(x, y+map[x][y]);
		}
	}
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		dfs(1, 1);
		
		if(check) {
			System.out.print("HaruHaru");
		}
		else {
			System.out.print("Hing");
		}
	}
}