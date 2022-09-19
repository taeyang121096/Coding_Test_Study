import java.io.*;
import java.util.*;

public class Boj_18428 {
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static char[][] arr;
	static int N;
	static List<int[]> teacher = new ArrayList<>();
	static List<int[]> space = new ArrayList<>();
	static boolean answer;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
				
		for(int i = 0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if(arr[i][j] == 'X') {
					space.add(new int[] {i, j});
				}
				if(arr[i][j] == 'T') {
					teacher.add(new int[] {i, j});
				}
			}
		}
		combination(0, new int[] {-1, -1, -1}, -1);
		
		if(answer) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	static void combination(int depth, int[] arr, int last) {
		if(depth == 3) {
			check(arr);
			return;
		}
		if(answer) return;
					
		for(int i = last + 1; i < space.size(); i++) {
			arr[depth] = i;
			combination(depth+1, arr, i);
		}
	}
	
	static void check(int[] tmp) {
		boolean[][] object = new boolean[N][N];
		for(int i = 0; i<3; i++) {
			object[space.get(tmp[i])[0]][space.get(tmp[i])[1]] = true;
		}
		for(int i = 0; i< teacher.size(); i++) {
			int[] now = teacher.get(i);
			for(int j = 0; j<4; j++) {
				int nx = now[0] + dx[j];
				int ny = now[1] + dy[j];
				while(nx < N && nx >= 0 && ny < N && ny >= 0 && !object[nx][ny]) {
					if(arr[nx][ny] == 'S') {
						return;
					}
					nx += dx[j];
					ny += dy[j];
				}
			}
		}
		answer = true;
	}
}