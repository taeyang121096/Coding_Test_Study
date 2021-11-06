package BOJ.code_plus;
import java.util.*;
public class _2609 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    int ans1=0;
    int ans2=0;
    if(a<=b){
      for(int i=1; i<=a; i++){
        if(a%i==0 && b%i==0) ans1=i;
      }
      for(int i=b; i<=a*b; i++){
        if(i%a==0 && i%b==0) {
          ans2=i;
          break;
        }
      }
    }else{
      for(int i=1; i<=b; i++){
        if(a%i==0 && b%i==0) ans1=i;
      }
      for(int i=a; i<=a*b; i++){
        if(i%a==0 && i%b==0) {
          ans2=i;
          break;
        }
      }
    }
    System.out.println(ans1);
    System.out.println(ans2);
  }
}
