package hyunsoo.goorm;
import java.io.*;
import java.util.*;
public class level2 {

	static int m,n;
	static String[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new String[m][n];
		
		for(int i=0; i<m; i++){
			String[] input = br.readLine().split("");
			for(int j=0; j<n; j++){
				arr[i][j]=input[j];
			}
		}
		
		String[][] answer = new String[m][n];
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(arr[i][j].equals("*")) {
					answer[i][j]="*";
					continue;
				}
				String ans = find(i,j);
				answer[i][j]=ans;
			}
		}
		
		for(int i=0; i<m;i++){
			for(int j=0; j<n; j++){
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}
	public static String find(int x, int y){
		int[] dx={0,0,1,-1 ,1,1,-1,-1 };
		int[] dy={1,-1,0,0 ,1,-1,1,-1 };
		int count=0;
		
		for(int i=0; i<8; i++){
			int tx=x+dx[i];
			int ty=y+dy[i];
			
			if(tx<0 || ty < 0 || tx>=m || ty>=n) continue;		
			if(arr[tx][ty].equals("*")) count++;
		}
		return String.valueOf(count);
	}
}
