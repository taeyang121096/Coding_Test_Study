import java.util.*;

public class SecreteMap {

    static int N;

    static String intToBinary(int val) {
        String num = Integer.toString(val, 2);
        int len = num.length();
        if (len < N) {
            for (int i = 0; i < N - len; i++) {
                num = "0" + num;
            }
        }
        return num;
    }

    static String map(String a1, String a2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a1.length(); i++) {
            if (a1.charAt(i) == '1') {
                sb.append("#");
            } else {
                if (a2.charAt(i) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
//         n보다 문자열 길이가 작을시 "0"을 붙여주기 위해서
        N = n;
//         arr1 , arr2 -> binary
        for (int i = 0; i < n; i++) {
            //                 이진법으로 변환
            String a1 = intToBinary(arr1[i]);
            String a2 = intToBinary(arr2[i]);

//                 and, or 해서 문자열 반환
            answer[i] = map(a1, a2);

        }
        return answer;
    }
}

