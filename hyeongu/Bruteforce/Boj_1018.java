import java.io.*;
import java.util.*;

public class Boj_1018 {
	public static boolean[][] chess;
	public static int check(boolean first , int x, int y) {
		int res = 0;
		for(int i = x; i<x+8; i++) {
			for(int j = y; j<y+8; j++) {
				if(chess[i][j]!=first) {
					res++;
				}
				first = !first;
			}
			first = !first;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		chess = new boolean [N][M];
		int answer = 64;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j<M; j++) {
				if(str.charAt(j) == 'B') {
					chess[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i<N-7; i++) {
			for(int j = 0; j<M-7; j++) {
				int min = Math.min(check(true, i, j), check(false, i, j));
				answer = Math.min(min, answer);
			}
		}
		System.out.println(answer);
	}
}