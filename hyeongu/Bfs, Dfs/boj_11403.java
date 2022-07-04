import java.util.*;
import java.io.*;

public class boj_11403 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] G = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k<N; k++) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(G[i][k]==1&&G[k][j]==1) {
						G[i][j] = 1;
					}
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(G[i][j]);
				if(j<N-1) {
					System.out.print(" ");
				}
			}
			if(i<N-1) {
				System.out.println("");
			}
		}
	}
}