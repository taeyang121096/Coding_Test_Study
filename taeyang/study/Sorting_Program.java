import java.util.*;
public class Sorting_Program {


    class Solution {
        //     위상 정렬 인 이유는 리프 노드를 찾아줘서 순환을 시켜야 하니까 필요한거고
//     위상 정렬은 그래프 중 사이클이 없는 그래프에 사용 해야 한다.
//     트리라서 다 더했을때 0이 되야 끝이 전부다 0으로 끝난다.
        public long solution(int[] a, int[][] edges) {

            long answer = 0;
            long sum = 0;
            List<Integer>[] list = new ArrayList[a.length];
            boolean[] check = new boolean[a.length];
            long[] val = new long[a.length];

            for(int i =0;i<a.length;i++){
                sum += a[i];
                val[i] = a[i];
                list[i] = new ArrayList<>();
            }

            if(sum !=0)
                return -1;
            int[] degree = new int[a.length];

            for(int[] e : edges){
                list[e[0]].add(e[1]);
                list[e[1]].add(e[0]);
                degree[e[0]]++;
                degree[e[1]]++;
            }

            Deque<Integer> q = new ArrayDeque<>();
            for(int i = 0;i<a.length;i++){
                if(degree[i] == 1)
                    q.offer(i);
            }
            while(!q.isEmpty()){
                int idx = q.poll();
                check[idx] = true;

                for(int i = 0;i<list[idx].size();i++){
                    int next = list[idx].get(i);
                    if(!check[next]){
                        degree[next]--;
                        val[next] += val[idx];
                        answer += Math.abs(val[idx]);
                        val[idx] = 0;
                        if(degree[next] == 1)
                            q.offer(next);
                    }
                }
            }




            return answer;
        }
    }
}
