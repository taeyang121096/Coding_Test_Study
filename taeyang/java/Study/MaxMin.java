import java.util.*;
public class MaxMin {

    static void cal(int first, int second){
        int lcm = 1;
        int fgc = 1;
        int count = 2;
        while(count <= Math.min(first,second)) {
            if (first % count == 0 && second % count == 0) {
                lcm = count * lcm;
                first /= count;
                second /= count;
                count = 2;
            }
            else{
                count++;
            }
        }
        if(lcm != 1)
            fgc = lcm *first *second;
        else
            fgc = first * second;
        System.out.println(lcm);
        System.out.println( fgc);
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();

        cal(first, second);



    }
}
