import java.util.*;
import java.io.*;

public class Boj_15661 {
	static int[][] arr;
	static int N;
	static int sum = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				sum += tmp;
				
				if(i>j) {
					arr[j][i] += tmp;
				}
				else {
					arr[i][j] += tmp;
				}
			}
		}
		for(int i = 2; i<= N/2; i++) {
			combination(i, -1, new int[i], 0);
		}
		System.out.println(min);
	}
	
	static void combination(int r, int last, int[] num, int depth) {
		if(depth == r) {
			boolean[] check = new boolean[N];
			for(int i = 0; i<r; i++) {
				check[num[i]] = true;
			}
			
			int score1 = 0;
			int score2 = 0;
			for(int i = 0; i<r-1; i++) {
				for(int j = i+1; j<r; j++) {
					score1 += arr[num[i]][num[j]];
				}
			}
			for(int i = 0; i<N-1; i++) {
				if(!check[i]) {
					for(int j = i+1; j<N; j++) {
						if(!check[j]) {
							score2 += arr[i][j];
						}
					}
				}
			}
			min = Math.min(min, Math.abs(score1 - score2));
			return;
		}
		
		for(int i = last + 1; i<N; i++) {
			num[depth] = i;
			combination(r, i, num, depth+1);
		}
	}
}
