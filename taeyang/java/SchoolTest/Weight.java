package School;
import java.util.*;
public class Weight {
    static Set<Integer> set = new LinkedHashSet<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        set.add(100);
        set.add(50);
        set.add(20);
        set.add(10);
        set.add(5);
        set.add(2);
        set.add(1);
        int n = Integer.parseInt(sc.nextLine());
        String num[] = sc.nextLine().split(" ");
        int left = 0;
        int right = 0;
        for(int i = 0;i<n;i++){
            if(left == right){
                left += Integer.parseInt(num[i]);
            }else{
                if(left > right)
                    right+=Integer.parseInt(num[i]);
                else
                    left += Integer.parseInt(num[i]);
            }
        }
        int dif = Math.abs(right-left);
        int count = 0;
        for(int val : set){
            if(dif == 0)
                break;
            if(dif/val != 0)
                count += dif/val;
            dif %= val;
        }
        System.out.println(count);

    }
}
