import java.util.*;
import java.io.*;

public class Boj_13140{
	static String N;
	static int len;
	static int[]arr;
	static int[] hello = new int[5];
	static int[] world = new int[5];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		len = N.length();
		if(len>6) {
			System.out.println("No Answer");
			return;
		}
		arr = new int[6];
		
		for(int i = 0; i<len; i++) {
			arr[len-1-i] = N.charAt(i) - '0';
		}		
		dfs(0, 0);
		System.out.println("No Answer");

	}
	
	public static void dfs(int up, int depth) {
		if(depth == 5) {			
			if(hello[4] != 0 && world[4] != 0 && up == arr[5]) {
				if(hello[1] == hello[2] && hello[1] == world[1] && hello[0] == world[3]) {
					if(check(hello, world)) {
						print(up, hello, world);
						System.exit(0);
					}
				}
				if(world[1] == world[2] && world[1] == hello[1] && world[0] == hello[3]) {
					if(check(world, hello)) {
						print(up, world, hello);
						System.exit(0);
					}
				}
			}
			return;
		}
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(((i + j + up) % 10) == arr[depth]) {
					hello[depth] = i;
					world[depth] = j;
					if(i + j + up > 9) {
						dfs(1, depth+1);
					}
					else {
						dfs(0, depth + 1);
					}
				}
			}
		}
	}
	
	public static boolean check(int[] hello, int[] world) {
		boolean[] visit = new boolean[10];
		
		for(int i = 0; i<5; i++) {
			if(!visit[hello[i]]) {
				visit[hello[i]] = true;
			}
			else {
				if(i != 2) return false;
			}
		}
				
		for(int i = 0; i<5; i++) {
			if(!visit[world[i]]) {
				visit[world[i]] = true;
			}
			else {
				if(i != 1 && i != 3) return false;
			}
		}
		return true;
	}
	public static void print(int up, int[] hello, int[] world) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for(int i = 4; i>=0; i--) {
			sb.append(hello[i]);
		}
		sb.append("\n").append("+ ");
		for(int i = 4; i>=0; i--) {
			sb.append(world[i]);
		}
		sb.append("\n").append("-------").append("\n");
		if(up == 1) {
			sb.append(" ").append(N);
		}
		else {
			sb.append("  ").append(N);
		}
		System.out.println(sb.toString());
	}
}