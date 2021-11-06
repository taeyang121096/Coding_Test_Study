package BOJ.code_plus;
import java.util.*;
public class _1918 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    char[] calcul = new char[str.length()];
    char[] stack = new char[str.length()];
    int calPoint=0;
    int calPoint2=0;
    int Point=0;
    boolean multiDivde =false;

    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      System.out.println(calPoint+" "+calPoint2);
      
      if(c=='(' || c==')'){
        if(c=='('){     
          calcul[calPoint++]='(';
          calPoint2++;    
        }
        else {      
          while(calPoint>0 && calcul[--calPoint] != '('){
              stack[Point++]=calcul[calPoint];
          }
          calPoint2--;        
        }
        continue;
      }
      
      if( c=='+' || c=='/' || c=='*' || c=='-'){
        if( (c=='+' || c=='-')){
          if(calPoint - calPoint2 ==0) calcul[calPoint++] = c;
          else{
            while(calPoint - calPoint2>0 && calPoint>0){
              if(calcul[calPoint]=='('){
                calPoint++;
                break;
              }
              stack[Point++]=calcul[--calPoint];        
            }
            multiDivde=false;
            calcul[calPoint++] = c;
          }
        }else{
          if(calPoint - calPoint2==0) {
            multiDivde=true;
            calcul[calPoint++] = c;
          }
          else{           
            if(multiDivde){
              while(calPoint - calPoint2>0 && calPoint>0 ){
                if(calcul[calPoint]=='('){
                calPoint++;
                break;
                }
                stack[Point++]=calcul[--calPoint];
              }
            }
            calcul[calPoint++] = c;
          }
        }
      }else{
        stack[Point++] = c;
      }
    }


    while(calPoint>0){
      if(calcul[calPoint]=='('){
        calPoint--; 
        if(calPoint<=0) break;
        else{
          stack[Point++]=calcul[--calPoint];
          continue;
        }
      }
      stack[Point++]=calcul[--calPoint];
    }

    System.out.print(String.valueOf(stack));
  }
}
