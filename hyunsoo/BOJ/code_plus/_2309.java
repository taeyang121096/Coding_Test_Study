package BOJ.code_plus;
import java.util.*;
public class _2309 {
  
  static boolean check = false;
  static int[] arr;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    arr= new int[9];
    
    int sum=0;
    for(int i=0; i<9;i++){
      arr[i]=sc.nextInt();
      sum+=arr[i];
    }

    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        if(i==j) continue;
        int tmp = sum-arr[i]-arr[j];
        if(tmp == 100){
          int[] ans = new int[7];
          int idx=0;
          for(int k=0; k<9; k++){
            if(k==i || k==j) continue;
            ans[idx++]=arr[k];
          }  
          Arrays.sort(ans);
          for(int num : ans){
            System.out.println(num);
          }
          return;
        }
      }
    }
  }
}

