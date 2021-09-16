import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i= 0;i<num;i++){
            ArrayList<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            String number = Integer.toBinaryString(n);
            StringBuilder sb = new StringBuilder(number);
            number = sb.reverse().toString();
            int count = 0;
            for(char c : number.toCharArray()){

                if(c == '1') {
                    list.add(count);
                }
                count++;
            }
            for(int k : list)
                System.out.print(k+" ");
        }





    }
}
