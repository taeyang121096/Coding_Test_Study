import java.util.*;
public class New_id {
    class Solution {
/*
    아이디 len : 3 ~ 15
    문자 : 소문자, 숫자, -, _, .
    조건 : . 은 처음과 끝에 사용 할 수 없으며 연속으로 사용x

    1. upper -> lower
    2. 가능한 문자를 제외하고 제거
    3. .. -> .
    4. . 처음 끝 제거
    5. 빈문자 -> a 추가
    6. 16자 이상 -> 15개 제외 제거 -> 4 체크 한번더
    7. 2자 이하이면 길이가 3이 될때까지 반복해서 append

    길이가 1 ~ 1000
    skill : contains, replace, replaceall, regex , substring, +

    1. upper -> lower
    2. replaceall([소문자, 숫자, 특수문자])
    3. .. -> . -> contains("..") -> . 치환
    4. charAt() -> substring()
    5. len == 0 -> new String(a)
    6. len > 15 -> substring(15)
    7. len <= 2 str += str;
*/

        public String check(String new_id){
            while( new_id.length() > 0 && (new_id.charAt(0) == '.' || new_id.charAt(new_id.length()-1) == '.')){
                if(new_id.charAt(0) == '.'){
                    if(new_id.length() >1){
                        new_id = new_id.substring(1);
                    }else{
                        new_id = "";
                    }
                }
                if(new_id.length()>=1 && new_id.charAt(new_id.length()-1) == '.'){
                    if(new_id.length() > 1){
                        new_id = new_id.substring(0,new_id.length()-1);
                    }else{
                        new_id = "";
                    }
                }

            }
            return new_id;
        }

        public String solution(String new_id) {
            String answer = "";
//         1. upper -> lower
            new_id = new_id.toLowerCase();
//         2. replaceall
            new_id = new_id.replaceAll("[^0-9a-z-_.]","");
//         3. .. -> .
            while(new_id.contains("..")){
                new_id = new_id.replace("..",".");
            }
            System.out.println(new_id);

//         4. substring()
            new_id = check(new_id);

//         5. len == 0
            if(new_id.length() == 0){
                new_id = "a";
            }
//         6. len > 15
            if(new_id.length() > 15){
                new_id = new_id.substring(0,15);
            }
//         4. substring()
            new_id = check(new_id);

//         7. 3 이상
            while(new_id.length() <= 2){
                new_id += new_id.charAt(new_id.length()-1);
            }

//         return
            answer = new_id;
            return answer;
        }
    }
}
