import java.io.*;
import java.util.*;

//백준 N과M(1) 15649

public class NandM1_BOJ {
	static int N; // 자연수 N
	static int M; // 수열의 길이 M
	static int arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visit = new boolean[N]; // 숫자의 방문여부
		dfs(0); // root부터
		System.out.println(sb);

	}

	public static void dfs(int depth) {
		if (depth == M) { // 깊이가 수열의 길이와 같을 때
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) { // 배열에 방문하지 않을 때
				visit[i] = true;
				arr[depth] = i + 1; // arr에 값을 추가해준다
				dfs(depth + 1); // 좀 더 깊게
				visit[i] = false; // return 되었을때 배열 방문여부를 false로
			}
		}

	}
}