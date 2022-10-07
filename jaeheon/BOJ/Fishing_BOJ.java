package BOJ;

import java.util.*;
import java.io.*;

public class Fishing_BOJ {
	
	static int n;
	static int l;
	static int m;
	static int answer = 0;
	static List<int[]> al;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		al = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.add(new int[] {a, b});
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 1; k < l/2; k++) {
					find(i, j, k, l/2 - k);
				}
			}
		}
		System.out.println(answer);
	}

	static void find(int x, int y, int netx, int nety) {
		
		int res = 0;
		for(int i = 0; i < m; i++) {
			if( al.get(x)[0] <= al.get(i)[0] && 
				al.get(i)[0] <= al.get(x)[0] + netx && 
				al.get(y)[1] <= al.get(i)[1] && 
				al.get(i)[1] <= al.get(y)[1] + nety) {
//				System.out.println("X : " + x + "   ///   " + "y : " + y + "   ///   res : " + res);
//				System.out.println("al.get(x)[0] : " + al.get(x)[0] + "   ///   " + "al.get(y)[1] : " + al.get(y)[1]);
				res++;
			}
		}
		answer = Math.max(answer, res);
		
	}
}
