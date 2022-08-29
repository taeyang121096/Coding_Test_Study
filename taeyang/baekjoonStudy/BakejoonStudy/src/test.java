import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;

public class test {
    static StringBuffer sb = new StringBuffer();
    static public void permutation(int level, int n, int m, int[] array, int idx){
        if(level == m){
            for(int val : array) {
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =idx;i<=n;i++){
            array[level] = i;
            permutation(level+1,n,m,array,i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(0, n,m, new int[m],1);

        System.out.println(sb.toString());
    }
}
