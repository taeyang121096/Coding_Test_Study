package hyunsoo.BOJ.code_plus;
import java.io.*;
import java.util.*;

public class _17299 {

  public static void main(String[] args) throws IOException{
    
    HashMap<Integer, Integer> map = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr= new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    for(int i=0; i<n; i++){
      int tmp=Integer.parseInt(st.nextToken());
      if(map.containsKey(tmp)){
        map.put(tmp,map.get(tmp)+1);
      }else{
        map.put(tmp,1);
      }
      arr[i]=tmp;
    }
  
    int[] stack = new int[n];
    stack[0] = 0;
    int point = 0; 
    for(int i=1; i<n; i++){
      while(map.get(arr[stack[point]]) < map.get(arr[i])){
        arr[stack[point--]]=arr[i];
        if(point<0){
          break;
        }
      }
      stack[++point] = i;
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
    while(point>=0){
      arr[stack[point--]]=-1;
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<n; i++){
      sb.append(arr[i]+" ");
    }
    System.out.print(sb.toString());
  }  
}
