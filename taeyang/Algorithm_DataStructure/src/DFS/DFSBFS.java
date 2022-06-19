package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS {
    static Map<Integer,List<Integer>> map;
    static boolean[] check;
    static StringBuilder sb;
    static void dfs(int v){
        if(check[v-1])
            return;
        sb.append(v+" ");
        check[v-1] = true;
        for(int i : map.get(v)){
            dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        check = new boolean[n];
//        map -> key , value -> key:int value : list
        map = new HashMap<>();
        sb = new StringBuilder();
//      초기화
        for(int i = 1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            map.get(f).add(s);
            map.get(s).add(f);
        }
        for(int i = 1;i<n;i++)
            map.get(i).sort(((o1, o2) -> o1-o2));

/**
 * 5 -> 4, 2
 * 4 -> 5 3
 * 3 -> 4 1
 * 2 -> 5 1
 * 1 -> 2 3
 */
        dfs(v);
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());



    }
}
