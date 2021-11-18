package Kyonggi_Algorithm_Competition;
import java.util.*;
import java.io.*;
public class _12 {
  	static class node{
		int e;
		int w;
		public node(int e, int w){
			this.e=e;
			this.w=w;
		}
	}
	static ArrayList<node>[] list;
	static int[] gyeonU;
	static int[] jignyeo;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		gyeonU = new int[n+1];
		jignyeo = new int[n+1];
		for(int i=0; i<=n; i++){
			gyeonU[i] = 100000000;
			jignyeo[i] = 100000000;
		}
		
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++){
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[v].add(new node(e,w));
			list[e].add(new node(v,w));
		}
		
		Dijk(A , gyeonU);	
		Dijk(B , jignyeo);
		
// 		for(int i=0; i<=n; i++){
// 			System.out.print(gyeonU[i]+" ");
// 		}
// 		System.out.println();
// 		for(int i=0; i<=n; i++){
// 			System.out.print(jignyeo[i]+" ");
// 		}
// 		System.out.println();
		
	
		int max = Integer.MAX_VALUE;
		
		for(int i = 1; i<=n; i++){
		
			int x = gyeonU[i];	
			int y = jignyeo[i];
			
			for(int j=0; j<list[i].size(); j++){
				node t = list[i].get(j);
				if(y > jignyeo[t.e]){
					y= jignyeo[t.e];
				}
			}
			int sum = Math.max(x,y);
			max = Math.min(max, sum);
		}
		System.out.println(max);
		
	}
	
	public static void Dijk(int index, int[] arr){
		
		Queue<Integer> pq = new LinkedList<>();
		
		arr[index]=0;
		pq.add(index);
		
		while(!pq.isEmpty()){
			int tmp = pq.poll();
			for(int i=0; i<list[tmp].size(); i++){
				node no = list[tmp].get(i);		
				if(arr[no.e] > arr[tmp] + no.w ){
					arr[no.e] = arr[tmp] + no.w;
					pq.add(no.e);
				}
			}
		}
		
	}
}
