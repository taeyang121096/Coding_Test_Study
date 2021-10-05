import java.util.*;
public class ChangeNumber {
    
    static int ans = Integer.MAX_VALUE;
    
    
    static void bfs(int start, int end){
        int count = 0;
        Deque<long[]> q = new ArrayDeque<>();
        q.offer(new long[]{start, 0});
        
        while(!q.isEmpty()){
            long[] s = q.poll();
            if(s[0] == end){
                ans = (int) Math.min(ans,s[1]+1);
                break;
            }
            long first = s[0] *2;
            long second = Long.parseLong(String.valueOf(s[0])+"1");
            if(first <= end) {
                q.offer(new long[]{first,s[1]+1});
            }
            if(second<= end) {
                q.offer(new long[]{second,s[1]+1});
            }
            
        }
        
    }
    
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        bfs(a,b);
        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);


    }
}
