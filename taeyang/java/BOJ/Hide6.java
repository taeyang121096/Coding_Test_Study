package basic;
import java.util.*;
public class Hide6 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] t = sc.nextLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int s = Integer.parseInt(t[1]);
        String[] num = sc.nextLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i<num.length;i++){
            list.add(Math.abs(Integer.parseInt(num[i-1]) - Integer.parseInt(num[i])));
        }
        list.add(Math.abs(s - Integer.parseInt(num[num.length-1])));
        if(list.size() == 0)
            System.out.println(list.get(0));
        else{
            int a = list.get(0);
            int b = 0;
            for(int i = 1;i<list.size();i++){
                b = list.get(i);
                if(a>b)
                    a = gcd(a,b);
                else
                    a = gcd(b,a);
            }
            System.out.println(a);
        }
    }
    static int gcd(int a,int b){

        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
