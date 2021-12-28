package basic;
import java.io.*;
import java.util.*;
public class LongBio {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr =new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i =0;i<n;i++){
            dp1[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[j]<arr[i] && dp1[i]<dp1[j]+1)
                    dp1[i] = dp1[j]+1;
            }
        }
        for(int i =n-1;i>=0;i--){
            dp2[i] = 1;
            for(int j = n-1;j>i;j--){
                if(arr[j]<arr[i] && dp2[i]<dp2[j]+1)
                    dp2[i] = dp2[j]+1;
            }
        }
        int[] sum = new int[n];
        for(int i = 0;i<n;i++)
            sum[i] = dp1[i]+dp2[i];
        int val = Arrays.stream(sum).max().getAsInt();
        System.out.println(val-1);

    }
}
