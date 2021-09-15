import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MultiTab {
    //    1<=N<=100 멀티탭 구멍 개수, 1<=k<=100 용품 사용횟수
//    2, 7
//    두번째 줄 전기용품 이름 2 3 2 3 1 2 7
    static int getIndex(int val, Queue<Integer> q){
        Object[] objects = q.toArray();
        for(int i = 0;i<q.size();i++){
            if(val == (int)objects[i])
                return i;
        }
        return q.size();
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] tab = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0;i<k;i++){
            int num = sc.nextInt();
            q.offer(num);
        }


        while(!q.isEmpty()){
            boolean flag = true;
            for(int i = 0;i<n;i++){
                if(tab[i] == 0||tab[i] == q.peek()){
                    tab[i] = q.poll();
                    flag = false;
                    break;
                }
            }
            if(flag){
                int val = 0;
                int max = Integer.MIN_VALUE;
                for(int i = 0;i<n;i++){
                    int index = getIndex(tab[i],q);
                    if(max<index){
                        max = index;
                        val = i;
                    }
                }
                tab[val] = q.poll();
                count++;
            }

        }
        System.out.println(count);


    }
}
