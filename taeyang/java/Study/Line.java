import java.util.*;
public class Line {

    static List<List<Integer>>list = new ArrayList<>();
    static Deque<Integer> q = new ArrayDeque<>();
    static Deque<Integer> res = new ArrayDeque<>();
    public  static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[n+1];
        int m = sc.nextInt();
        for(int i = 0;i<n+1;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<m;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list.get(v1).add(v2);
            count[v2] += 1;
        }
        for(int i = 1;i<n+1;i++){
            if(count[i] == 0)
                q.offer(i);
        }
        
        while(!q.isEmpty()){
            int v1 = q.poll();
            res.offer(v1);

            for(int v2 : list.get(v1)) {
                count[v2] -= 1;
                if(count[v2] == 0)
                    q.offer(v2);
            }
        }
        for(int ans : res)
            System.out.print(ans+" ");

    }
}
