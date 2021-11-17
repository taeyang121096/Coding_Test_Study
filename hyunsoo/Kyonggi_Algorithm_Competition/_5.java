package Kyonggi_Algorithm_Competition;
import java.util.*;
import java.io.*;
public class _5 {
  public static class node{
		int x;
		int y; 
		int w;
		int h;
		public node(int x, int y, int w , int h){
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static node[] arr;
	static int n,W,H;
	
  public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr= new node[n];
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			int h= Integer.parseInt(st.nextToken());
			arr[i] = new node(x,y,w,h);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine()," ");
			int tx= Integer.parseInt(st.nextToken());
			int ty= Integer.parseInt(st.nextToken());
			check(tx,ty);
		}
		System.out.print(sb.toString());
	}
	
	public static void check(int tx, int ty){
		boolean check =false;
		for(int i=0; i<arr.length; i++){
			int x = arr[i].x;
			int y = arr[i].y;
			int w = arr[i].w;
			int h = arr[i].h;
			
			if( x<tx && tx<x+w  && y<ty && ty<y+h){
				sb.append("NO\n");
				check=true;
			}else if( x<tx+W && tx+W<x+w  && y<ty && ty<y+h){
				sb.append("NO\n");
				check=true;
			}else if( x<tx && tx<x+w  && y<ty+H && ty+H <y+h){
				sb.append("NO\n");
				check=true;
			}else if( x<tx+W && tx+W<x+w  && y<ty+H && ty+H<y+h){
				sb.append("NO\n");
				check=true;
			}else if( tx<x && x<tx+W  && ty<y && y<ty+H){
				sb.append("NO\n");
				check=true;
			}else if( tx<x+w && x+w<tx+W  && ty<y && y<ty+H){
				sb.append("NO\n");
				check=true;
			}else if( tx<x && x<tx+W  && ty<y+h && y+h<ty+H){
				sb.append("NO\n");
				check=true;
			}else if( tx<x+w && x+w<tx+W  && ty<y+h && y+h<ty+H){
				sb.append("NO\n");
				check=true;
			}
			
			if(check) return;
		}
		sb.append("OKAY\n");
	}
}
