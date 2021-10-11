import java.util.*;
public class DivideNet {
        static int[] parent;
        static void union(int parents, int child){
            int p = find(parents-1);
            int c = find(child-1);
            if(p!=c)
                parent[c] = p;
        }
        static int find(int index){
            if(index == parent[index])
                return index;
            return parent[index] = find(parent[index]);
        }
        public int solution(int n, int[][] wires) {
            int answer = -1;
            int size = wires.length;

            int ans = 100;

            for(int i = 0 ;i<size;i++){
                parent = new int[n];
                for(int k = 0;k<n;k++)
                    parent[k] = k;
                for(int j = 0;j<size;j++){
                    if(i == j)
                        continue;
                    union(wires[j][0],wires[j][1]);
                }
                int count1 = 0;
                int count2 = 0;
                int tmp = find(parent[0]);
                for(int k = 0;k<n;k++){
                    if(tmp != find(parent[k])){
                        count2++;
                    }else
                        count1++;
                }
                ans = Math.min(ans,Math.abs(count1-count2));
            }
            answer = ans;
            return answer;
        }
    }
