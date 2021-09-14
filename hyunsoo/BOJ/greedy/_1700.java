package BOJ.greedy;
import java.util.*;

public class _1700 {
  
  public static void main(String[] args){
      
      Scanner sc =new Scanner(System.in);
      HashSet<Integer> hs = new HashSet<>();

      int N= sc.nextInt();
      int K= sc.nextInt();
      int[] arr= new int[K];
      int answer=0;
      for(int i=0; i<K; i++){
        arr[i]=sc.nextInt();
      }

      for(int i=0; i<K; i++){
        if(hs.contains(arr[i])) continue;

        if(hs.size()==N){
          int max=Integer.MIN_VALUE;
          Iterator<Integer> iter = hs.iterator();
          
          while(iter.hasNext()){
            int tmp = iter.next();
            boolean check=true;
            for(int j=i; j<K; j++){
              if(tmp==arr[j]) { max=Math.max(max, j); check=false; break;}
            }
            if(check) { 
              //System.out. println("remove "+tmp); 
              hs.remove(tmp); answer++; 
              break;
            }
          }

          if(hs.size()==N){
            //System.out.println("remove "+ arr[max]);
            hs.remove(arr[max]);
            answer++;
          }
        }
      
        hs.add(arr[i]);
        
      }
      System.out.println(answer);
  }
}
