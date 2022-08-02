// n개의 노드와 n-1개의 간선으로 이루어진 트리
// 하나의 간선을 제거하여 2개의 트리로 나눔
// 이때 두 트리의 노드의 갯수의 차가 최소가 되는 경우 차이를 리턴
// 2<n<100, 1 <= v1 < v2 <= n

import java.util.*;

class Solution {
    public int findNode(int n, int[][] wires, int start, int ban){
        boolean[] check = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int res = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            check[now] = true;
            for(int i = 0; i<n-1; i++){
                if(wires[i][0] == now && !check[wires[i][1]] && wires[i][1] != ban){
                    q.offer(wires[i][1]);
                    res++;
                }
                if(wires[i][1] == now && !check[wires[i][0]] && wires[i][0] != ban){
                    q.offer(wires[i][0]);
                    res++;
                }
            } 
        }
        return res;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
                
        for(int i = 0; i<wires.length; i++){
            int a = findNode(n, wires, wires[i][0], wires[i][1]);
            answer = Math.min(answer, Math.abs(n-2*a));
        }
        return answer;
    }
}