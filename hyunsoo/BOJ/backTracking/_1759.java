package BOJ.backTracking;
import java.util.*;
public class _1759 {

  static int L,C;
  static char[] c;
  static StringBuilder sb=new StringBuilder();
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] tmp = sc.nextLine().split(" ");
    L=Integer.parseInt(tmp[0]);
    C=Integer.parseInt(tmp[1]);

    c = new char[C];
    String[] str=sc.nextLine().split(" ");
    for(int i=0; i<C; i++){
      c[i]= str[i].charAt(0);
    }

    Arrays.sort(c);
    find("",0,0,0,0);
    System.out.print(sb.toString());

  }

  public static void find(String str, int index,int select, int conson,int vowel){
    
    if(select==L && conson >=2 && vowel >=1){
      sb.append(str+"\n");
      return;
    }
    if(index>=C) return;

    if(c[index]=='a' || c[index]=='e'|| c[index]=='i' || c[index]=='o'|| c[index]=='u'){
      find(str+c[index],index+1,select+1,conson,vowel+1);
      find(str,index+1,select,conson,vowel);
    }else{
      find(str+c[index],index+1,select+1,conson+1,vowel);
      find(str,index+1,select,conson,vowel);
    }
  }
}
