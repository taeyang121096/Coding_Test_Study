package BOJ.basicCheck;
import java.util.*;
public class _2309 {
  static int[] arr=new int[9];
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int sum=0;
    for(int i=0; i<9; i++){
      arr[i]=sc.nextInt();
      sum +=arr[i];
    }

    int remove1=-1, remove2=-1;

    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        if(i==j) continue;
        int check= sum-arr[i]-arr[j];
        if(check==100){
          remove1=i;
          remove2=j;
        }
      }
    }

    int[] answer = new int[7];
    int index=0;
    for(int i=0; i<9; i++){
      if(i==remove1 || i==remove2) continue;
      answer[index++]=arr[i];
    }

    Arrays.sort(answer);
    for(int i=0; i<7; i++){
      System.out.println(answer[i]);
    }
  } 
}
