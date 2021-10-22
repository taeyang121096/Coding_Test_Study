import java.util.*;
import java.io.*;
public class Rainin {
    static int[] val;
    static int count = 0;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int height = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        val = new int[len];
        st = new StringTokenizer(br.readLine()," ");
        int max = 0;
        int left = 0;
        int right = 0;
        for(int i = 0;i<len;i++){
            val[i] = Integer.parseInt(st.nextToken());
            if(max < val[i]){
                max = val[i];
                left = i;
            }
        }
        max = 0;
        for(int i = len-1;i>=0;i--){
            if(max < val[i]){
                max = val[i];
                right = i;
            }
        }
        int start = val[0];
        int end = val[len-1];
        for(int i = 1;i<left;i++){
            if(start <= val[i]) {
                start = val[i];
                continue;
            }
            count += start - val[i];
        }
        for(int i = len-2;i>right;i--){
            if(end <= val[i]) {
                end = val[i];
                continue;
            }
            count += end - val[i];
        }
        for(int i = left;i<right;i++){
            count += max - val[i];
        }
        System.out.println(count);
    }
}
