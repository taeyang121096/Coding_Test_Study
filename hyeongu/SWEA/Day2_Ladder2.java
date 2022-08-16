// 사다리타기의 경로중 최단거리를 return

import java.util.*;
import java.io.*;
public class Day2_Ladder2 {
	static int[][] arr;
	static int[] dx = {0, 0, 1};
	static int[] dy = {-1, 1, 0};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 1; i<=10; i++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	arr = new int[100][100];
        	List<Integer> al = new ArrayList<>();
        	for(int j = 0; j<100; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int k = 0; k<100; k++) {
        			arr[j][k] = Integer.parseInt(st.nextToken());
        			
        			if(j == 0 && arr[j][k] == 1) {
        				al.add(k);
        			}
        		}
        	}
        	int answer = al.get(0);
        	int min = bfs(al.get(0));
        	for(int j = 1; j<al.size(); j++) {
        		int tmp = bfs(al.get(j));
        		if(min >= tmp) {
        			answer = al.get(j);
        			min = tmp;
        		}
        	}
        	System.out.println("#" + i + " " + answer);
        }
	}
	static int bfs(int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[100][100];
		int res = 0;
		
		q.offer(new int[] {0, y});
		visit[0][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i<3; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny<0|| nx>=100 ||ny>=100) {
					continue;
				}
				if(!visit[nx][ny] && arr[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					visit[nx][ny] = true;
					res++;
					break;
				}
			}
		}
		return res;
	}
	
}