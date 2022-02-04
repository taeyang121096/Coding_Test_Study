import java.util.*;
import java.io.*;

public class Virus_softeer {


    // 2 *3 -> 6 6 *3 = 18
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int val = k;
        for (int i = 0; i < n; i++) {
            val = (val * p) % 1000000007;
        }

        System.out.println(val);
    }
}
