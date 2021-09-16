package BOJ;
import java.util.*;
import java.io.*;
public class _14719 {
  static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer (br.readLine()," ");

    int h = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    arr = new int[r];
    st=new StringTokenizer(br.readLine()," ");
    for(int i=0; i<r; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int sum=0;
    int max = findmax(0, r-1);

    sum+=left(0,max-1);
    sum+=right(max+1,r-1);

    System.out.println(sum);
  }

  public static int left(int x, int y ){
    if(x>=y) return 0;

    int max= findmax(x,y);
    int height = arr[max];
    int sum=0;
    for(int i=max+1; i<=y; i++){
      sum+= (height-arr[i]);
    }

    return sum + left(x,max-1);
  }

  public static int right(int x, int y){
    if(x>=y) return 0;

    int max= findmax(x,y);
    int height = arr[max];
    int sum=0;
    for(int i=x; i<max; i++){
      sum+= (height-arr[i]);
    }

    return sum+ right(max+1, y);

  }

  public static int findmax(int left, int right){
      
      int max=Integer.MIN_VALUE;
      int index=0;
      
      for(int i=left; i<=right; i++){
        if(max<arr[i]){
          max=arr[i];
          index=i;
        }
      }
      return index;
  }
}
