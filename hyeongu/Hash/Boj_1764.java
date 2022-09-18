import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> hs = new HashSet<>();
        Set<String> ts = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            hs.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(hs.contains(str)){
                ts.add(str);
            }
        }

        sb.append(ts.size()).append("\n");
        for (String str : ts) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}