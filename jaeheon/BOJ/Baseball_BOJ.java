package BOJ;

import java.util.*;
import java.io.*;

public class Baseball_BOJ {
	
	static int n;
	static int[] player; // pick
	static boolean[] visit;
	static int[][] list;
	static boolean[] base;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		player = new int[9];
		visit = new boolean[9];
		list = new int[n][9];
		
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		player[3] = 0;
		visit[3] = true;
		
		dfs(1);
		System.out.println(answer);
	}

	static void dfs(int depth) {
		if(depth == 9) {
			calc();
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				player[i] = depth;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

	static void calc() {
		int sum = 0;
		int idx = 0;
		for(int i = 0; i < n; i++) {
			base = new boolean[4];
			int out = 0;
			while(out < 3) {
				int play = list[i][player[idx++]];
				if(play == 0) {
					out++;
				} else if(play == 1) {
					sum += move(1);
				} else if(play == 2) {
					sum += move(2);
				} else if(play == 3) {
					sum += move(3);
				} else if(play == 4) {
					sum += move(4);
				}
				
				if(idx == 9) {
					idx = 0;
				}
			}
		}
		
		answer = Math.max(sum, answer);
	}

	//   2  
	// 3   1
	//   0
	static int move(int hit) {
		base[0] = true;
		int score = 0;
		int idx = 3;
		while(idx >= 0) {
			if(base[idx]) {
				base[idx] = false;
				
				if(idx + hit >= 4) {
					score++;
					continue;
				}
				base[idx + hit] = true;
			}
			idx--;
		}
		
		return score;
	}
}
