package BOJ.basicCheck;
import java.util.*;

public class _10870 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr= new int[21];
    
    arr[0]=0;
    arr[1]=1;
    arr[2]=1;
    if(n<3){ 
        System.out.println(arr[n]);
        return;
    }
      
    for(int i=3; i<=n; i++){
      arr[i]=arr[i-1]+arr[i-2];
    }
    System.out.println(arr[n]);
  }
}
