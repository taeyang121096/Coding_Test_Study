package hyunsoo.BOJ.code_plus;
import java.util.*;
public class _1935 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String str= sc.nextLine();

    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i]=Integer.parseInt(sc.nextLine());
    }

    int point=0;
    double[] stack = new double[str.length()];

    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(c-'A'>=0 && c-'A'<26){
        stack[point++]= arr[c-'A'];
      }else{
        double y = stack[--point];
        double x = stack[--point];

        switch(c){
          case '+':
            stack[point++]=x+y;
            break;
          case '-':
            stack[point++]=x-y;
            break;
          case '*':
            stack[point++]=x*y;
            break;
          case '/':
            stack[point++]=x/y;
            break;  
        }

      }
    }

    System.out.printf("%.2f",stack[0]);
  }
}
