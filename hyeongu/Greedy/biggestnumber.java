// k개의 수를 제거해서 가장 큰 숫자를 문자열 형태로 리턴 -> Stringbuilder
// number는 100만자리 이하

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        for(int i = 0; i<number.length()-k; i++){
            int max = 0;
            for(int j = index; j<=i+k; j++){
                int tmp =number.charAt(j)-'0';
                if(tmp>max){
                    max = tmp;
                    index = j+1;
                    if(max==9){
                        break;
                    }
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}