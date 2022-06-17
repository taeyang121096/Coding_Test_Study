import java.util.*;
import java.io.*;
 
public class baek_11725 {
    static boolean[] visit;
    static ArrayList<Integer> []tree;
    static int answer[];
    static int N;
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        tree = new ArrayList[N+1];
        answer = new int[N+1];
 
        for(int i = 0; i <= N; i++)
        	tree[i] = new ArrayList<>();
 
        //ArrayList에 인덱스값과 연결되어있는 숫자를 add
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
 
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
 
            tree[num1].add(num2);
            tree[num2].add(num1);
        }
        //root인 1에서 dfs
        dfs(1);
        for(int i = 2; i <= N; i++)
            System.out.println(answer[i]);
    }
 
    static void dfs(int num){
        visit[num] = true;
        for(int i :tree[num]){
            if(!visit[i]) {
            	answer[i] = num;
                dfs(i);
            }
        }
    }
}
