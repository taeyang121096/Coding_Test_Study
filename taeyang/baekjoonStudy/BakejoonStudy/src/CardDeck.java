import java.util.*;
public class CardDeck {
    class Solution {
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";
            Queue<String> q1 = new LinkedList<String>();
            Queue<String> q2 = new LinkedList<String>();
            for(String str: cards1){
                q1.offer(str);
            }
            for(String str: cards2){
                q2.offer(str);
            }
            boolean flag = true;

            for(String str: goal){
                if(q1.contains(str)){
                    if(!q1.poll().equals(str)){
                        flag = false;
                        break;
                    }
                }else if(q2.contains(str)){
                    if(!q2.poll().equals(str)){
                        flag = false;
                        break;
                    }
                }else{
                    flag = false;
                    break;
                }

            }
            if(!flag){
                answer = "No";
            }
            else{
                answer = "Yes";
            }


            return answer;
        }
    }
}
