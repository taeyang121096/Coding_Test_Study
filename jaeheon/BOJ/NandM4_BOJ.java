import java.io.*;
import java.util.*;

//백준 N과M(4) 15652

public class NandM4_BOJ {
	static int N; // 자연수 N
	static int M; // 수열의 길이 M
	static int arr[];
//	static boolean visit[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
//		visit = new boolean[N]; // 숫자의 방문여부
		dfs(1, 0); // root부터
		System.out.println(sb);

	}

	public static void dfs(int at, int depth) { //at - 현재 위치, 즉 어디서부터 시작하는지를 의미하는 변수이다
		if (depth == M) { // 깊이가 수열의 길이와 같을 때
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		// 실제 알고리즘
		for (int i = at; i <= N; i++) {
            arr[depth] = i; //현재 깊이의 위치에 i 값을 담는다
            dfs(i, depth + 1);
        }

	}
}