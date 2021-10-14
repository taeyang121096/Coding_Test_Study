import java.util.*;
import java.io.*;

public class Supervise {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long count = 0;
        for(int i = 0;i<n;i++){
            int val = arr[i];

            count++;
            val -= b;
            if(val <= 0)
                continue;
            int cnt = val/c;
            int rest = val%c;
            if(rest !=0){
                count++;
            }
            count += cnt;
        }
        System.out.println( count);

    }
}
