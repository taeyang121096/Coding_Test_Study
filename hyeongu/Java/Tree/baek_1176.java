import java.io.*;
import java.util.*;

public class baek_1176{
    static int n;
    static ArrayList<Node>[] tree; //연결된 노드와 거리를 저장하는 객체를 Node클래스로 선언
    static boolean[] visited;
    static int max = 0;
    static int idx = 0;
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[n+1];
        for(int i=1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            while(true){
                int num2 = Integer.parseInt(st.nextToken());//연결된 노드
                if(num2 == -1) break;
                
                int dist = Integer.parseInt(st.nextToken());//거리
                tree[num1].add(new Node(num2, dist));
                tree[num2].add(new Node(num1, dist));
            }
        }
        visited = new boolean[n+1];
        dfs(1, 0); //임의의 한 지점에서 가장 거리가 먼 노드를 구함
        visited = new boolean[n+1];
        dfs(idx, 0); //위에서 구한 노드에서 가장 거리가 먼 노드를 구함
        
        System.out.println(max);
    }
    
    private static void dfs(int num1, int sum){
        visited[num1] = true;
        
        if(sum > max){
            max = sum;
            idx = num1;
        }
        
        for(Node target : tree[num1]){
            if(visited[target.index]) continue;
            dfs(target.index, sum + target.dist);
        }
    }
}

class Node{
    int index;
    int dist;
    public Node(int index, int dist){
        this.index = index;
        this.dist = dist;
    }
}