package BOJ;

// 백준 3085 사탕게임

import java.io.*;

public class CandyGame_BOJ {
	
	static char[][] candy; // 사탕 배열
	static String line; // 한줄 입력
	static int answer;
	
	static void check() {
		int tmp = 1;
		// 가로
		for(int i = 0; i < candy.length; i++) {
			tmp = 1;
			for(int j = 0; j < candy[i].length - 1; j++) {
				if(candy[i][j] == candy[i][j+1]) {
					tmp++;
					if(answer < tmp) {
						answer = tmp;
					}
				} else {
					tmp = 1;
				}
			}
		}
		// 세로
		for(int i = 0; i < candy.length; i++) {
			tmp = 1;
			for(int j = 0; j < candy[i].length - 1; j++) {
				if(candy[j][i] == candy[j+1][i]) {
					tmp++;
					if(answer < tmp) {
						answer = tmp;
					}
				} else {
					tmp = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		answer = 0;
		
		candy = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			line = br.readLine();
			for(int j = 0; j < n; j++) {
				candy[i][j] = line.charAt(j);
			}
		}
		
		char tmp = ' ';
		// 가로
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				if(candy[i][j] != candy[i][j+1]) {
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
					check();
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
				}
			}
		}
		//세로
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				if(candy[j][i] != candy[j+1][i]) {
					tmp = candy[j][i];
					candy[j][i] = candy[j+1][i];
					candy[j+1][i] = tmp;
					check();
					tmp = candy[j][i];
					candy[j][i] = candy[j+1][i];
					candy[j+1][i] = tmp;
				}
			}
		}
		System.out.println(answer);
	}
}