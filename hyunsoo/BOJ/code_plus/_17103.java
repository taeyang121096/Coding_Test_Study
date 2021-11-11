package BOJ.code_plus;
import java.util.*;
public class _17103 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    HashMap<Integer,Integer> hs= new HashMap<>();

    int point=0;
    for(int i=2; i<= 1000000; i++){
      boolean check = false;
      for(int j=2; j*j<=i; j++){
        if(i%j==0) { check = true; break;}
      }
      if(!check) hs.put(point++,i);
    }
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    for(int i=0; i<n; i++){
      int tmp = sc.nextInt();
      
      int left=0;
      int right= point-1;
      int count =0;
      while(left<=right){
        int a = hs.get(left);
        int b = hs.get(right);
        if(a+b == tmp){
          count++;
          left++;
          right--;
        }else if(a+b<tmp){
          left++;
        }else{
          right--;
        }
      }
      sb.append(count+"\n");
    }
    System.out.print(sb.toString());
  }
}
