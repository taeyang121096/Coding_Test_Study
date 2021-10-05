import java.util.*;
public class Hide {
//    n = 수빈 k = 동생 0~100,000
//    수빈 1) 걷기 -> x+1, x-1 2) 순간이동 2*x 1초
//
//
    static int ans = Integer.MAX_VALUE;
    static int cnt = 0;
    static boolean [] check = new boolean[100001];
    static void bfs(int start, int end,int count){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start,count});

        while(!q.isEmpty()){
            int[] s = q.poll();
            check[s[0]] = true;
            if(s[0] == end){
                if(ans >= s[1]){
                    ans = Math.min(ans,s[1]);
                    cnt++;
                }else{
                    break;
                }
            }
            int first =s[0] -1;
            if(first >= 0 && check[first] != true )
                q.offer(new int[]{first,s[1]+1});
            int second = s[0] +1;
            if(second <= 100000 && check[second] != true)
                q.offer(new int[]{second,s[1]+1});
            int third = 2 * s[0];
            if(third <= 100000 && check[third] != true) {
                q.offer(new int[]{third, s[1] + 1});
            }
        }
    }

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        bfs(n,k,0);
        System.out.println(ans);
        System.out.println(cnt);

    }
}
