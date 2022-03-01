package Programmers;
import java.util.*;

public class kPrimeCount {

    static boolean isPrime(int N){
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        int n = 110011;
        int k = 10;

        // 숫자 2진수로 바꾸기 11 % 2 = 1, 5 % 2 = 1, 2 % 2 = 0/  if(n == 1)
        while(n >= k){ // 3, 3
            int b = n % k; // 나머지 11 % 3 = 2, 3 % 3 = 0
            n = n/k; // 3 = 11 / 3, n = 3, 3 / 3 = 1
            deque.offerFirst(b);
            if(n < k){ // 3 < 3,
                deque.offerFirst(n);
            }
        }

        String tmp = "";
        while(!deque.isEmpty()){
            if(deque.peek() != 0){
                tmp += String.valueOf(deque.pollFirst());
                if(deque.isEmpty())
                    list.add(Integer.parseInt(tmp));
            } else if(deque.peek() == 0){
                deque.pollFirst();
                if(tmp != "")
                    list.add(Integer.parseInt(tmp));
                tmp = "";
            }
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i)) && list.get(i) != 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
