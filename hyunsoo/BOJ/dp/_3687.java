package BOJ.dp;
import java.util.*;

public class _3687 {

  static String[] max_dp=new String[101];
  static String[] min_dp=new String[101];
  static int[][] num={{},{},{1},{7},{4},{2,3,5},{0,6,9},{8}};
                    //0   1  2   3   4    5       6       7
  public static void main(String[] args){
    
    
    for(int i=3; i<=100; i++){
      if(i%2==1) max_dp[i]=max_dp[i-1].replaceFirst("1","7");
      else max_dp[i]= 1+max_dp[i-2];

      min_dp[i]="99999999999999999";    
    }
    StringBuilder sb = new StringBuilder();
    /** min 
     * 2 => 1
     * 3 => 7
     * 4 => 4
     * 5 => 2
     * 6 => 6
     * 7 => 8
     * 8 => 10
     * 9 -> 18
     * 10 > 22
     * 11 > 26
     */

     min_dp[2]=""+1;
     min_dp[3]=""+7;
     min_dp[4]=""+4;
     min_dp[5]=""+2;
     min_dp[6]=""+0;   // 나중에 6으로 바꿔서 출력해야함
     min_dp[7]=""+8;
     min_dp[8]=""+10;

     //9999999   999+ 00   999
     for(int i=9; i<=100; i++){
       for(int j=2; j<(i-1); j++){
        if(Long.parseLong(min_dp[i]) > Long.parseLong(min_dp[i-j]+min_dp[j])){
           if( (min_dp[i-j]+min_dp[j]).length() == check(Long.parseLong(min_dp[i-j]+min_dp[j]))){
              min_dp[i]= min_dp[i-j]+min_dp[j];
           }
        }
       }
     }
     min_dp[6]=""+6;
    
 
     Scanner sc = new Scanner(System.in);
     
     int T=Integer.parseInt(sc.nextLine());
     for(int i=0; i<T; i++){
       int tmp = Integer.parseInt(sc.nextLine());    
       //sb.append(min_dp[tmp]+" "+max_dp[tmp]+"\n");
       //System.out.println(min_dp[tmp]+" "+max_dp[tmp]);
     }

     System.out.print(sb.toString());
    // for(int i=2; i<=100; i++){
    //   System.out.println(i+" "+min_dp[i]+" "+max_dp[i]);
    // }
  }

  static int check(long l){
    
    int count=1;
    while(l/10 > 0){
      l=l/10;
      count++;
    }

    return count;
  }
}
