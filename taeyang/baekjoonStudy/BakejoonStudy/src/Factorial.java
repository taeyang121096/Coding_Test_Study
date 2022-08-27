import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

    /**
     * 10 -> 10 9 8 7 6 5 4 3 2 1
     * 9 -> 9 8 7 6 5 4 3 2 1
     * 8 -> 8 7 6 5 4 3 2 1
     * 7 -> 7 6 5 4 3 2 1
     * 6 -> 6 5 4 3 2 1
     * 5 -> 5 4 3 2 1
     *  4 ->  4 3 2 1
     *  3 -> 3 2 1
     *  2 -> 2 1
     */

        public static void main(String[]args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int two = 0;
            int five = 0;
            for(int i = 1;i<=n;i++){
                int tmp = i;
                while(tmp % 2 ==0){
                    two++;
                    tmp /=2;
                }
                while(tmp%5==0){
                    five++;
                    tmp /=5;
                }
            }
            System.out.println(Math.min(two,five));
        }


}
