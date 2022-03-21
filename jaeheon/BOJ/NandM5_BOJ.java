package BOJ;

//백준 n과m(6) 15654

import java.util.*;
import java.io.*;
// 입력
// 첫째줄 : n ,m
// 둘째줄 : n개의 수

// 중복되는 수열 여러번 출력 x
// 각 수열은 공백으로 구분
// 수열은 사전 순 증가
// -> 주어진 수를 순차적으로 출력

public class NandM5_BOJ {
	static int n, m;
	static int[] arr;
	static int[] answer;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        answer = new int[n];
        visit = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(0);
        System.out.println(sb);
        
	}

	static void dfs(int depth) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 실제 알고리즘
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				answer[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
