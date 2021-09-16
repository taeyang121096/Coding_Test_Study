package BOJ.basicCheck;
import java.util.*;
public class _2609 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a=1,b=1;

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    
    if(x1<y1){
      for(int i=x1; i>0; i--){
        if(x1%i==0 && y1%i==0) {a=i; break;} 
      }
      
      for(int i=y1; i<=x1*y1; i++){
        if(i%x1==0 && i%y1==0) {b=i; break; }
      }
    }else{
      for(int i=y1; i>0; i--){
        if(x1%i==0 && y1%i==0) {a=i; break;} 
      }
      
      for(int i=x1; i<=x1*y1; i++){
        if(i%x1==0 && i%y1==0) {b=i; break;} 
      }
    }
    System.out.println(a+"\n"+b);
  }  
}
