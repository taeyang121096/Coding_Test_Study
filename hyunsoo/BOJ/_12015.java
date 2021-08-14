package BOJ;

import java.io.*;
import java.util.*;

public class _12015 {
  
  static ArrayList<Integer> arr = new ArrayList<>();
  
  public static void binarySearch(int k, int start, int end){
    
    while(start<end){
      
      int mid=(start+end)/2;
      
      if(arr.get(mid)<k) start=mid+1;
      else end = mid;  
    }
    arr.set(end,k);

  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n= Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    arr.add(Integer.parseInt(st.nextToken()));
    
    for(int i=0; i<n-1; i++){

      int k = Integer.parseInt(st.nextToken());
      if(k>arr.get(arr.size()-1)){
        arr.add(k);
      }else{
        binarySearch(k,0,arr.size()-1);
      }
    }

    System.out.print(arr.size());
  }
}
