package BOJ.TwoPointer;
import java.util.*;
public class _1806 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int s=sc.nextInt();
    sc.nextLine();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i]=sc.nextInt();
    }

    int left=0;
    int right=0;
    int sum=0;
    int leng=Integer.MAX_VALUE;

    while(right<n && left<=right){
      sum+=arr[right++];

      if(sum>=s){
        while(sum>=s){
          sum-=arr[left++];
        }
        left--;
        int tmp=right-left;
        sum+=arr[left];
        leng=Math.min(leng,tmp);
      }
    }

    if(leng==Integer.MAX_VALUE) leng=0;
    System.out.println(leng);
  }
}
