import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] leaf;
    static boolean[] visit;
    static List<int[]>[] data;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        leaf = new boolean[N];
        data = new List[N];
        answer = 0;

        for(int i = 0; i < N; i++){
            data[i] = new ArrayList<int[]>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            leaf[parent] = true;
            data[parent].add(new int[] {child, cost});
            data[child].add(new int[] {parent, cost});
        }
        leaf[0] = false;
        
        for(int i = 0; i < N; i++){
            if(!leaf[i]){
                visit = new boolean[N];
                dfs(i, 0);
            }
        }
        System.out.println(answer);
    }

    static void dfs(int node, int cost){
        visit[node] = true;
        for(int i = 0; i < data[node].size(); i++){
            int[] tmp = data[node].get(i);
            if(!visit[tmp[0]]){
                dfs(tmp[0], cost + tmp[1]);
            }
        }
        if(!leaf[node]){
            answer = Math.max(answer, cost);
        }
    }
}