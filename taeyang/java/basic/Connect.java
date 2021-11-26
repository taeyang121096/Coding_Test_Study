package basic;
import java.util.*;
import java.io.*;
public class Connect {

    static int[] parent;
    static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int u,int v){
        u = find(u);
        v = find(v);
        if(u!=v)
            parent[v] = u;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1;i<=n;i++)
            parent[i] = i;
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u,v);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1;i<=n;i++)
            set.add(find(parent[i]));
        System.out.println(set.size());
    }
}
