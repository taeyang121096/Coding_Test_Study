package Programmers;

import java.util.*;
class IslandConnection_Prog {
//     최소비용으로 모든 섬이 통행 가능하도록
//     건너 건너도 된다
//     섬은 n 1 ~ 100
//     cost len = (n-1)*n /2
//     0 s 1 e 2 cost
//     무방향 그래프
//     
    
    static int[] parent;
    
    static int find(int val){
        if(parent[val] == val)
            return val;
        return parent[val] = find(parent[val]);
    }
        
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        
        parent[b] = a;
    }
    
    public int solution(int n, int[][] costs) {
//         트리 이겠구나
//         서로소를 찾아주는 기본적인 알고리즘이거든
//         스패닝 트리 -> 트리가 원래 순환이 되면 안되잖아 
//         그런 부분을 찾아주는거야 이렇게 트리를 찾아주는 이걸 활용하면 트리를 찾아 줄 수 있어
        int answer = 0;
        parent = new int[n];
        
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        for(int i = 0;i<n;i++)
            parent[i] = i;
//         0 - 1   1의 부모를 0으로 바꿔주는거야
        for(int[] c : costs){
            int a = c[0];
//             3
            int b = c[1];
//             2
            if(find(a) == find(b))
                continue;
            union(a,b);
            answer += c[2];
        }
        
        return answer;
    }
}