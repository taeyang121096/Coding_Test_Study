import java.util.*;
public class SumNum {
    
    public static void main(String[]args){
        Scanner sc =new Scanner(System.in);
        long S = sc.nextLong();
        long sum = 0;
        int n = 0;
        for(int i = 1;;i++){
            sum += i;
            if(sum > S) {
                n = i - 1;
                break;
            }

        }
        System.out.println( n);
    }
}
