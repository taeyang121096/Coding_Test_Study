import java.util.ArrayList;
import java.util.Scanner;

public class Measure {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1;i<=n;i++){
            if(n%i == 0)
                list.add(i);
        }
        if(list.size() >= k)
            System.out.print(list.get(k-1));
        else
            System.out.println(0);



    }
}
