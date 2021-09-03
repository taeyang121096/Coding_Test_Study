/**
 * 2021 카카오 채용연계형 인텁십 숫자 문자열과 영단어
 */

package kakao;

public class NumberString {
  class Solution {
    public int solution(String s) {
        String[] numArr={"zero", "one", "two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0; i<numArr.length; i++){
            s=s.replace(numArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
}
