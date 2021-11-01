package hyunsoo.BOJ.code_plus;
import java.util.*;
public class _10799 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int answer = 0;
    
    int count = 0;
    boolean lazer= false;
    String str = sc.nextLine();
    for(int i=0; i<str.length(); i++){
      char tmp = str.charAt(i);
      if(tmp=='('){
        lazer=true;
        count++;
      }
      else{
        if(lazer){
          count--;
          answer +=count;
          lazer=false;
        }else{
          answer ++;
          count--;
        }
      }
    }
    System.out.println(answer);
  }
}
