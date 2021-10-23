package BOJ.nhnCommerce;
import java.util.*;
import java.io.*;
public class _2304 {

  static int N;
  static int[][] pill;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    pill = new int[N][2];
    
    int x=0;
    int max=0;
    for(int i=0; i<N; i++){
      String[] tmp = br.readLine().split(" ");
      pill[i][0]=Integer.parseInt(tmp[0]);
      pill[i][1]=Integer.parseInt(tmp[1]);
      
    }

    Arrays.sort(pill, new Comparator<int[]>(){
      public int compare(int[] o1, int[] o2){
        return o1[0]-o2[0];
      }
    });

    for(int i=0; i<N; i++){
      if(max<pill[i][1]){
        max=pill[i][1];
        x=i;
      }
    }

    int answer=0;

    int leftmax = pill[0][1];
    int leftx= pill[0][0];
    for(int i=0; i<=x; i++){
      if(leftmax<=pill[i][1]){
        int t = pill[i][0]-leftx;
        answer += t * leftmax;
        leftmax = pill[i][1];
        leftx = pill[i][0];
      }
    }
    
    int rightmax = pill[N-1][1];
    int rightx = pill[N-1][0];
    
    for(int i=N-1; i>=x; i--){
      if(rightmax<=pill[i][1]){
        int t = rightx - pill[i][0];
        answer += t * rightmax;
        rightmax = pill[i][1];
        rightx = pill[i][0];
      }
    }
    answer += max;

    System.out.println(answer);
  }    
}
