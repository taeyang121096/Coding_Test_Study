import java.util.*;
import java.io.*;

public class boj_2606 {
	public static int[][] graph;
	public static int bfs(int n, int m) {
		Deque<Integer> deque = new ArrayDeque<>();
		boolean[] isVisit = new boolean[m+1];
		int count = 0;
		deque.add(n);
		while(!deque.isEmpty()) {
			int i = deque.pop();
			if(!isVisit[i]) {
				count++;
				isVisit[i] = true;
				for(int j = 1; j<m+1; j++) {
					if(graph[j][i]==1||graph[i][j]==1) {
						deque.add(j);
					}
				}
			}
		}
		return --count;
	}
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int node = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int edge = Integer.parseInt(st.nextToken());
		
		graph = new int [node+1][node+1];

		while(edge-- > 0) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		System.out.print(bfs(1, node));
	}
}
