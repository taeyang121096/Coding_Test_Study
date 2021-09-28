package BOJ;
import java.util.*;
public class _1038 {
  
  static int N;
  static String answer;
  static int index=9;
  static boolean check=false;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    N=sc.nextInt();

    if(N<10) {
      System.out.println(N);
    }else if(N>1022){
      System.out.println("-1");
    }else{
      int leng=2;
      while(!check){
        for(int i=1; i<=9; i++){
          if(check) break;
          decrease(N,i+"",leng,i,1);
        }
        leng++;
      }
      System.out.println(answer);
    }
    
    
  }
  public static void decrease(int N, String str ,int leng, int last, int strleng){
    if(strleng==leng) {
      index++; 
      if(index==N) {
        answer=str;
        check=true;
      }
      return;
    }

    for(int i=0; i<last; i++) {
      if(check) return; 
      decrease(N,str+i,leng,i,strleng+1);
    }
  } 
}
