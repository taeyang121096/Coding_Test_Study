public class OutBlock {
    import java.util.*;
    class Solution {

        static List<int[]> list = new ArrayList<>();
        static List<int[]> dlist = new ArrayList<>();
        static int N;
        static int size;
        static boolean [] check;
        static void make(int start, int[] weak){
            int[] tmp = new int[weak.length];
            int index = 0;
            for(int i = start;i<weak.length;i++)
                tmp[index++] = weak[i];
            for(int i = 0;i<start;i++)
                tmp[index++] = weak[i] + N;
            list.add(tmp);
        }

        static void make_dist(int start, int[] dist,int level, int[] val){
            if(level == size){
                int[] tmp = val.clone();
                dlist.add(tmp);
                return;
            }

            for(int i = 0;i<size;i++){
                if(check[i])
                    continue;
                val[level] = dist[i];
                check[i] = true;
                make_dist(i+1,dist,level+1,val);
                check[i] = false;
            }

        }

        static int check(){

            int ans = Integer.MAX_VALUE;

            for(int[] w : list){

                for(int[] d : dlist){
                    int value = w[0];
                    for(int i = 0;i<size;i++){
                        boolean flag = true;
                        int cost = d[i];
                        value = cost+value;
                        for(int j = 0;j<w.length;j++){
                            if(w[j] > value){
                                value = w[j];
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            ans = Math.min(ans,i+1);
                            break;
                        }

                    }
                }
            }

            return ans;
        }

        public int solution(int n, int[] weak, int[] dist) {
            int answer = 0;
//         초기화

            N = n;
            size = dist.length;
            check = new boolean[size];
            for(int i = 0;i<weak.length;i++){
                make(i,weak);
            }
            make_dist(0,dist,0,new int[size]);

            answer = check();
            if(answer == Integer.MAX_VALUE)
                return -1;

            return answer;
        }
    }
}
