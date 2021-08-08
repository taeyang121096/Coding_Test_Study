package algorithmTest;
/*гу╫б ец╫ц ©Д╠щ*/
public class Taxi {
	
	import java.util.*;
	class Solution {
	    
	    static int[][] graph;
	    static int min = Integer.MAX_VALUE;
	    
	    public void weight(int[][]fares){
	        for(int[] x: fares){
	            graph[x[0]][x[1]] = x[2];
	            graph[x[1]][x[0]] = x[2];
	        }
	    }
	    
	    public int[] result(int root, int n){
	        int [] res = new int[n+1];
	        
	        Arrays.fill(res,Integer.MAX_VALUE);
	        res[root] = 0;
	        
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(root);
	        while(!q.isEmpty()){
	            int tmp = q.poll();
	            
	            for(int i =1;i<n+1;i++){
	                if(i == tmp ) continue;
	                
	                if(graph[tmp][i] == Integer.MAX_VALUE) continue;
	                else{
	                    if(res[i] > graph[tmp][i] + res[tmp]){
	                        res[i] = graph[tmp][i] + res[tmp];
	                        q.offer(i);
	                    }
	                    
	                }
	            }            
	            
	        }
	        return res;
	       
	    }
	    
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = 0;
	        graph = new int[n+1][n+1]; 
	        for(int i = 1;i<n+1;i++){
	            Arrays.fill(graph[i],Integer.MAX_VALUE);
	            graph[i][i] = 0;
	        }
	        weight(fares); 
	        int[] S = result(s,n);
	        int[] A = result(a,n);
	        int[] B = result(b,n);
	        for(int i = 1;i<n+1;i++){
	            int sum = S[i]+A[i]+B[i];
	            if(sum<min) min = sum;
	        }
	        
	        answer= min;
	      
	        
	        
	        return answer;
	    }
	}

}
