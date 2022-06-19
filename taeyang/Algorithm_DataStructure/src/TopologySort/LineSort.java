package TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineSort {
    static int[] cost;
    static Map<Integer, List<Integer>>map = new HashMap<>();

    static void topologySort(){


        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<cost.length;i++){
            if(cost[i] == 0)
                q.offer(i+1);
        }
//      위상정렬 알고리즘
        while(!q.isEmpty()){
            int val = q.poll();
            sb.append(val+" ");
            for(int i : map.get(val)) {
                cost[i-1]--;
                if (cost[i - 1] == 0)
                    q.offer(i);
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i<=n;i++)
            map.put(i,new ArrayList<>());
        cost = new int[n];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            map.get(f).add(s);
            cost[s-1]++;
        }
        topologySort();
    }
}
