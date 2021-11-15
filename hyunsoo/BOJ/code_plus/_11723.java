package BOJ.code_plus;
import java.util.*;
import java.io.*;
public class _11723 {
  
  static Set<String> hs;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());

    hs = new HashSet<>();

    for(int i=0; i<m; i++){
      String[] str = br.readLine().split(" ");
      solution(str);
    }

    System.out.print(sb.toString());
  }

  public static void solution(String[] str){

    if(str.length==1){
      if(str[0].equals("all")){
        hs.clear();
        for(int i=1; i<=20; i++){
          hs.add(i+"");
        }
      }
      if(str[0].equals("empty")){
        hs.clear();
      }
    }else{
      if(str[0].equals("add")){
        hs.add(str[1]);
      }else if(str[0].equals("remove")){
        if(hs.contains(str[1])){
          hs.remove(str[1]);
        }
      }else if(str[0].equals("check")){
        if(hs.contains(str[1])){
          sb.append("1\n");
        }else{
          sb.append("0\n");
        }
      }else if(str[0].equals("toggle")){
        if(hs.contains(str[1])){
          hs.remove(str[1]);
        }else{
          hs.add(str[1]);
        }
      }
    }
  }
}
