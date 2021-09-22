import java.util.*;
public class EasyProblem {

    public static void main(String[]args){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i  =1;i<=1000;i++){
            for(int j = i;j>0;j--)
                list.add(i);
        }
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int ans = 0;
        while(start <=end){
            ans += list.get(start-1);
            start++;
        }
        System.out.println( ans);
    }
}
