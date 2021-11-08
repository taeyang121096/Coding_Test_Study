package BOJ.code_plus;
import java.util.*;
public class _2004 {
  
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    int count2=0, count5=0;
     
    for(int i=1; i<=n; i++){
      
      if( i> n-m && i<=m ) continue;
      
      int c2=0,c5=0;
      if(i%2==0) c2 = countTotal2(i); 
      if(i%5==0) c5 = countTotal5(i); 

      if(i>n-m){
        count2 +=c2;
        count5 +=c5;
      }
      if(i<=m){
        count2 -=c2;
        count5 -=c5;
      }

    }

    //System.out.println(count2 +" "+count5);
    if(count2 == -1 || count5 == -1) System.out.print(0);
    else System.out.print(Math.min(count2,count5));
    
  }

  public static int countTotal2(int x){

    int count =0;
    while(x%2 == 0 && x !=0){
      count++;
      x = x/2;
    }

    return count;
  }
  public static int countTotal5(int x){

    int count =0;
    while(x%5 == 0 && x!=0){
      count++;
      x = x/5;
    }
    return count;
  }

}
