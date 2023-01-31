package BOJ;

import java.util.*;
import java.io.*;

public class TreeDiameter_BOJ {

    static int n;
    static List<int[]>[] al;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        al = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            al[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            al[start].add(new int[] {end, cost});
            al[end].add(new int[] {start, cost});
        }

        answer = 0;
        for(int i = 1; i <= n; i++){
            visit = new boolean[n+1];
            dfs(i, 0);
        }
        System.out.println(answer);
    }
    static void dfs(int node, int dis){
        visit[node] = true;

//        for(int[] tmp : al[node]){
//            if(visit[tmp[0]]){
//                continue;
//            }
//            visit[tmp[0]] = true;
//            dfs(tmp[0], dis + tmp[1]);
//        }
        for(int i = 0; i < al[node].size(); i++){
            if(visit[al[node].get(i)[0]]){
                continue;
            }
//            visit[al[node].get(i)[0]] = true;
            dfs(al[node].get(i)[0], dis + al[node].get(i)[1]);
        }
        answer = Math.max(answer, dis);
    }
}
