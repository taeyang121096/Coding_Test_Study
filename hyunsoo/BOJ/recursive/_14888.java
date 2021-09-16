package BOJ.recursive;
import java.util.*;
public class _14888 {
  static int[] arr;
  static int[] cal= new int[4];
  static int N;
  static int max= Integer.MIN_VALUE;
  static int min= Integer.MAX_VALUE;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    N=sc.nextInt();
    arr= new int[N];
    
    for(int i=0; i<N; i++){
      arr[i]=sc.nextInt();
    }
    for(int i=0; i<4; i++){
      cal[i]=sc.nextInt();
    }

    make(0,0,0);

    System.out.println(max);
    System.out.println(min);
  }

  public static void make(int left,int index,int sum){

    if(index==0){
      sum = sum+arr[left++];
    }else if(index==1){
      sum=sum-arr[left++];
    }else if(index==2){
      sum=sum*arr[left++];
    }else{
      sum=sum/arr[left++];
    }
    if(left==N){
      max=Math.max(max,sum);
      min=Math.min(min,sum);
      return;
    }

    for(int i=0; i<4; i++){
      if(cal[i]>0){
        cal[i]--;
        make(left,i,sum);
        cal[i]++;
      }
    }
  }
  
}
