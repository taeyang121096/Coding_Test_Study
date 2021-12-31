import java.util.*;
import java.io.*;
public class Yosepuse_BOJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 1;i<=n;i++)
            q.offer(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for(int i = 1;i<k;i++){
                int val = q.pollFirst();
                q.offer(val);
            }
            sb.append(String.valueOf(q.pollFirst())+", ");
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
