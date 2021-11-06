package BOJ.code_plus;
import java.io.*;

public class _10808 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[26];

    String str = br.readLine();
    for(char c : str.toCharArray()){
      arr[c-'a']++;
    }

    for(int i=0; i<26; i++){
      System.out.print(arr[i]+" ");
    }
  }  
}
