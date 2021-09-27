package BOJ.basicCheck;
import java.util.*;
public class _2294 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int n=Integer.parseInt(input[0]);
    int k=Integer.parseInt(input[1]);
    
    HashSet<Integer> hs = new HashSet<>();

    for(int i=0; i<n; i++){
      hs.add(Integer.parseInt(sc.nextLine()));
    }
    
    int[] coin = new int[hs.size()];
    Iterator iter = hs.iterator();
    int h=0;
    while(iter.hasNext()){
      coin[h++]=(Integer)iter.next();
    }

    Arrays.sort(coin);

    int[] answer = new int[k+1];
    for(int i=1; i<=k; i++) answer[i]=Integer.MAX_VALUE-1;

    for(int i=0; i<coin.length; i++){
      for(int j=coin[i]; j<=k; j++){
        answer[j]=Math.min(answer[j],answer[j-coin[i]]+1);
      }
    }

    if(answer[k]==Integer.MAX_VALUE-1) System.out.println("-1");
    else System.out.println(answer[k]);
  }
}
