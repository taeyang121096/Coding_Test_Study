import java.util.*;
public class TwoBit {

    //numbers의 길이 100,000
// numbers의 모든 수 10^15
// 비트가 1 or 2개 다르면서 큰수
// 00일때 100 -> 101 -> 하나 다른거
// 01일때 101 -> 110 -> 두개 다른거
// 10일때 110 -> 111 -> 하나 다른거
// 11일때 011 -> 101 // 0111 -> 1011 // 1011 -> 1101
// 01이 나오면 10으로 바꿈
// 근데 11 -> 100 or 111 -> 1000 이건 안됨

// 0 1  2  3   4   5   6   7    8    9   10   11   12   13
// 0 1 10 11 100 101 110 111 1000 1001 1010 1011 1100 1101

// 100111101111011
// 011111111111


    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % 4 == 3){ // 4로 나눴을 때 나머지 3
                    StringBuilder str = new StringBuilder(Long.toString(numbers[i], 2));
                    if(!str.toString().contains("0")){
                        String tmp = "0" + str.toString();
                        tmp = tmp.replaceFirst("01", "10");
                        Long num = Long.valueOf(tmp, 2);
                        answer[i] = num;
                    } else {
                        int idx = str.lastIndexOf("01");
                        str.setCharAt(idx, '1');
                        str.setCharAt(idx+1, '0');
                        Long num2 = Long.valueOf(str.toString(), 2);
                        answer[i] = num2;
                    }
                } else {
                    answer[i] = numbers[i] + 1;
                }
            }

            return answer;
        }
    }
}
