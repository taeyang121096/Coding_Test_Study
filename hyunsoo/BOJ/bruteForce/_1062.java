package BOJ.bruteForce;
import java.util.*;
public class _1062 {
  // a, n , t, i ,c   
  static boolean[] visit=new boolean[26];
  static String[] str;
  static int answer=0;
  static int n;
  static int k;
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    n=sc.nextInt();
    k=sc.nextInt();
    sc.nextLine();
    if(k<5){
      System.out.println("0");
      return;
    }
    if(k==26){
      System.out.println(n);
      return;
    }

    str = new String[n];
    for(int i=0; i<n; i++){
      String s= sc.nextLine();
      s.replace("anta","");
      s.replace("tica","");
      str[i]=s;
    }

    visit['a'-'a']=true;
    visit['n'-'a']=true;
    visit['t'-'a']=true;
    visit['i'-'a']=true;
    visit['c'-'a']=true;

    for(int i=0; i<31-k; i++)
      dfs(i,0,k-5);
    System.out.println(answer);
  }
  
  public static void dfs(int index,int select ,int length){
    if(select==length){
      int count=0;
      for(int i=0; i<n; i++){
        boolean check=true;
        for(int j=0; j<str[i].length(); j++){
          char c = str[i].charAt(j);
          if(visit[c-'a']) continue;
          check=false;
        }
        if(check) count++;
      }
      answer=Math.max(answer,count);
    }

    for(int j=index+1; j<26; j++){
      if(!visit[j]){
        visit[j]=true;
        dfs(j,select+1,length);
        visit[j]=false;
      }
    }
  }
}
