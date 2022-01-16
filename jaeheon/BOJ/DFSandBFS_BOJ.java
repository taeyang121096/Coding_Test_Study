import java.io.*;
import java.util.*;

// 백준  dfs와 bfs    1260
public class DFSandBFS_BOJ {
	
	static int[][] arr;
	static boolean[] visit;
	static int n, m, v;
	static StringTokenizer st;
	static StringBuilder sb;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		 dfs(v);
	     sb.append("\n");
	     bfs(v);
	     
	     System.out.println(sb);
	}
	
	public static void check(){
        for(int i = 0 ; i < visit.length; i++) {
        	visit[i] = false;
        }
    }
	
	public static void dfs(int start) {
		sb.append(start).append(" ");
		visit[start] = true;
		for(int i = 1; i < visit.length; i++) {
			if(arr[start][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		check();
		queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            sb.append(num).append(" ");

            for(int i = 1; i < visit.length; i++){
                if(i != num && visit[i] == false && arr[num][i] == 1) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
        sb.append("\n");
	}
}
