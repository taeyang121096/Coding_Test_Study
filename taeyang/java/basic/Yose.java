package basic;
import java.util.*;
public class Yose {

    static Deque<Integer> q = new ArrayDeque<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        for(int i = 1;i<=n;i++)
            q.offer(i);
        while(!q.isEmpty()){
            for(int i = 0;i<k-1;i++){
                q.offerLast(q.pollFirst());
            }
            list.add(q.pollFirst());
        }
        System.out.print("<");
        for(int i = 0;i<list.size()-1;i++)
            System.out.print(list.get(i)+", ");
        System.out.print(list.get(list.size()-1)+">");
    }
}
