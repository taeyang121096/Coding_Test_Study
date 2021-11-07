package BOJ.code_plus;
import java.util.*;
public class _11656 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str= sc.nextLine();

    String[] arr = new String[str.length()];

    for(int i=0; i<str.length(); i++){
      arr[i]=str.substring(i);
    }

    Arrays.sort(arr);
    StringBuilder sb =new StringBuilder();
    for(String st : arr){
      sb.append(st+"\n");
    }
    System.out.println(sb.toString());
  }
}
