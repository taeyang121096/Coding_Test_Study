import java.util.*;
public class DigitEng {

    class Solution {

    /*
     return 값이 20억이므로 stringbuilder를 사용
     Map -> String, Integer -> ex) (zero, 0)
     1. for -> charAt().isLetter()
     2. char case -> list.add(charAt())
     3. 숫자를 만나면 list.toString -> key 로 사용해서 Map에서 Integer를 가져온다
     4. num case -> stringbuilder.append(num)
    */

        public int solution(String s) {
            int answer = 0;
//         초기화
            List<String> list = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>(){{
                put("zero",0);
                put("one",1);
                put("two",2);
                put("three",3);
                put("four",4);
                put("five",5);
                put("six",6);
                put("seven",7);
                put("eight",8);
                put("nine",9);
            }};
            StringBuilder ans = new StringBuilder();

//         각 문자 확인
            for(int i = 0;i<s.length();i++){
//             문자가 들어왔을경우
                if(Character.isLetter(s.charAt(i))){
                    list.add(String.valueOf(s.charAt(i)));
//                 map에 key가 존재하는지 확인
                    if(map.containsKey(String.join("",list))){
                        ans.append(map.get(String.join("",list)));
                        list.clear();
                    }
                }else{
//                 숫자일경우
                    ans.append(s.charAt(i));
                }

            }
//         list가 안비어있을 경우
            if(list.size() != 0){
                ans.append(map.get(String.join("",list)));
            }
//         string to integer
            answer = Integer.parseInt(ans.toString());
            return answer;
        }
    }
}
