import java.util.*;

public class KPrime_Kakao {

    static void changeK(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String[] tmp = sb.reverse().toString().split("0");
        changeT(tmp);
    }

    static void changeT(String[] num) {
        for (String n : num) {
            if (n.length() == 0)
                continue;
            long val = Long.parseLong(n);
            if (val > 1)
                prime(val);
        }
    }

    static void prime(long val) {
        boolean flag = true;
        for (long i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag)
            answer++;
    }

    static int answer;

    public int solution(int n, int k) {
        answer = 0;
        changeK(n, k);

        return answer;
    }
}

