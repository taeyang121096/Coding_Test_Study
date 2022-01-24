import java.util.*;
public class Clustering_Kakao {

    // 1. 문자열 2개씩 잘라서 만들기 -> 소문자
// 2. 문자열 리스트에 넣기
// 3. 문자열 set 만들기
// 4. 교집합 합집합 만들기
// 5. 65536 곱하고 floor

        public int solution(String str1, String str2) {

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            List<String> s1 = new ArrayList<>();
            List<String> s2 = new ArrayList<>();
            Set<String> set = new HashSet<>();
            int start = 'a';
            int end = 'z';
            for(int i = 0;i<str1.length()-1;i++){
                if(str1.charAt(i)>=start&&str1.charAt(i)<=end&&str1.charAt(i+1)<=end&&str1.charAt(i+1)>=start)
                    s1.add(str1.substring(i,i+2));
            }
            for(int i = 0;i<str2.length()-1;i++){
                if(str2.charAt(i)>=start&&str2.charAt(i)<=end&&str2.charAt(i+1)<=end&&str2.charAt(i+1)>=start)
                    s2.add(str2.substring(i,i+2));
            }
            for(String s : s1){
                set.add(s);
            }
            for(String s : s2){
                set.add(s);
            }

            double union = 0;
            double inter = 0;

            for(String s :set){

                int first = Collections.frequency(s1,s);
                int second = Collections.frequency(s2,s);
                if(first == second){
                    inter += first;
                    union += first;
                } else if(first > second){
                    inter += Math.min(first,second);
                    union += Math.max(first,second);
                } else if(first < second){
                    inter += Math.min(first,second);
                    union += Math.max(first,second);
                }
            }
            int ans =1;

            if(union == 0){
                ans = 65536;
            }else{
                ans = (int)Math.floor((inter/union) * 65536);
            }



            return ans;
        }
    }

