package hyunsoo.BOJ.code_plus;
import java.util.*;
public class _17298 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc. nextInt();
    int[] arr= new int[n];
    for(int i=0; i<n; i++){
      arr[i]=sc.nextInt();
    }

    
    int[] stack = new int[n];
    stack[0] = 0;
    int point = 0; 
    for(int i=1; i<n; i++){
      while(arr[stack[point]] < arr[i]){
        arr[stack[point--]]=arr[i];
        if(point<0){
          break;
        }
      }
      stack[++point] = i;
    }

    // for(int i=0; i<n; i++){
    //   System.out.print(stack[i]+" ");
    // }
    // System.out.println();
    // for(int i=0; i<n; i++){
    //   System.out.print(arr[i]+" ");
    // }
    // System.out.println();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    while(point>=0){
      arr[stack[point--]]=-1;
    }

    for(int i=0; i<n; i++){
      System.out.print(arr[i]+" ");
    }
  }
}
