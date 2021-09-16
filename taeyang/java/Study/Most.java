import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Most {

    public static void main(String[]args){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0;i<n;i++){
            int m = sc.nextInt();
            list.add(m);
        }
        Collections.sort(list);
        System.out.println(list.get(0)+" "+ list.get(list.size()-1));
    }
}
