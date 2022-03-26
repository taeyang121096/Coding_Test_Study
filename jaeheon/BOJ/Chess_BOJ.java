package BOJ;

// 백준 1018 체스판 다시 칠하기

// 8 8 체스판 만들기
// 0,0 w or b
// 8 8 구역은 아무데서나 골라도 된다
// answer = 다시 칠해야 하는 부분의 최소

import java.io.*;
import java.util.*;

public class Chess_BOJ {
	
	static String[] chessB = {  
			"BWBWBWBW", "WBWBWBWB", 
			"BWBWBWBW", "WBWBWBWB", 
			"BWBWBWBW", "WBWBWBWB",
			"BWBWBWBW", "WBWBWBWB"};
	
	static String[] chessW = {
			"WBWBWBWB", "BWBWBWBW",
			"WBWBWBWB", "BWBWBWBW", 
			"WBWBWBWB", "BWBWBWBW", 
			"WBWBWBWB", "BWBWBWBW", };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = Integer.MAX_VALUE;
        
        char[][] chessMap = new char[N][M];
        
        for(int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for(int j = 0; j < M; j++) {
        		chessMap[i][j] = input.charAt(j);
        	}
        }
        
        int cntW = 0;
        int cntB = 0;
        
        // 시작점 잡기
        for(int i = 0; i <= N-8; i++) {
        	for(int j = 0; j <= M-8; j++) {
        		
        		// 8 by 8 검사
        		for(int a = 0; a < 8; a++) {
        			for(int b = 0; b < 8; b++) {
        				if(chessW[a].charAt(b) != chessMap[a+i][b+j]) {
        					cntW++;
        				} else if(chessB[a].charAt(b) != chessMap[a+i][b+j]){
        					cntB++;
        				}
        			}
        		}
        		answer = Math.min(answer, Math.min(cntW, cntB));
        		cntW = 0;
        		cntB = 0;
        	}
        }
        System.out.println(answer);
	}
}
