public class Programers3 {
    import java.util.*;
    class Solution {
        static int[]cost;
        static boolean[] check;
        static HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        static void bfs(int ver){
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(ver);
            while(!q.isEmpty()){
                int v = q.poll();
                if(check[v])
                    continue;
                check[v] = true;
                for(int dest : map.get(v)){
                    if(cost[dest] > cost[v]+1){
                        cost[dest] = cost[v]+1;
                        q.offer(dest);
                    }
                }
            }


        }
        public int solution(int n, int[][] edge) {
            int answer = 0;
            cost = new int[n+1];
            check = new boolean[n+1];
            Arrays.fill(cost,Integer.MAX_VALUE);
            cost[1] = 0;
            for(int i = 1;i<=n;i++){
                map.put(i,new ArrayList<Integer>());
            }
            for(int[] e : edge){
                map.get(e[0]).add(e[1]);
                map.get(e[1]).add(e[0]);
            }
            bfs(1);
            int max = cost[1];
            answer = 0;
            for(int i = 2;i<=n;i++){
                if(max<cost[i]){
                    max = cost[i];
                    answer = 1;
                }else if(max == cost[i]){
                    answer++;
                }

            }


            return answer;
        }
    }
}
