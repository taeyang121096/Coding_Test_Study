package BOJ.code_plus;
import java.util.*;
import java.io.*;

public class _3085 {
  
  static int count=0;
  static int n=0;
  static char[][] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr= new char[n][n];

    for(int i=0; i<n; i++){
      String tmp = br.readLine();
      for(int j=0; j<n; j++){
        arr[i][j]=tmp.charAt(j);
      }
    }

    for(int i=0; i<n-1; i++){
        checkA(i,i+1);
        checkB(i,i+1);
    }
    
    // for(int i=0; i<n-1; i++){
    //   for(int j=0; j<n; j++){
        
    //     char tmp = arr[i][j];
    //     arr[i][j]=arr[i+1][j];
    //     arr[i+1][j]=tmp;
    //     checkA(i,i+1);

    //     tmp = arr[i][j];
    //     arr[i][j]=arr[i+1][j];
    //     arr[i+1][j]=tmp;
    //   }
    // }
    
    // for(int i=0; i<n; i++){
    //   for(int j=0; j<n-1; j++){
        
    //     char tmp = arr[i][j];
    //     arr[i][j]=arr[i][j+1];
    //     arr[i][j+1]=tmp;
    //     checkB(i,i+1);

    //     tmp = arr[i][j];
    //     arr[i][j]=arr[i][j+1];
    //     arr[i][j+1]=tmp;
    //   }
    // }

    System.out.print(count);
  }
  
  public static void checkA(int x, int y){
    int max1=0,  max2=0;
    int count1=1, count2=1;
    char c1 = arr[x][0], c2 =arr[y][0];
    for(int i=1; i<n; i++){
      if(c1 == arr[x][i]){
        count1++;
      }else{
        c1 = arr[x][i];
        max1 = Math.max(max1,count1);
        count1=1;
      }

      if(c2 == arr[y][i]){
        count2++;
      }else{
        c2 =arr[y][i];
        max2 = Math.max(max2,count2);
        count2=1;
      }
    }
    int max = Math.max(max1,max2);
    count = Math.max(count,max);
  }

  public static void checkB(int x, int y){
    int max1=0,  max2=0;
    int count1=1, count2=1;
    char c1 = arr[0][x], c2 =arr[0][y];
    for(int i=1; i<n; i++){
      if(c1 == arr[i][x]){
        count1++;
      }else{
        c1 = arr[i][x];
        max1 = Math.max(max1,count1);
        count1=1;
      }

      if(c2 == arr[i][y]){
        count2++;
      }else{
        c2 =arr[i][y];
        max2 = Math.max(max2,count2);
        count2=1;
      }
    }
    int max = Math.max(max1,max2);
    count = Math.max(count,max);
  }
}
