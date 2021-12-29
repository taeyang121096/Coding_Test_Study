import java.util.*;
public class WatherMelon_Pro {


    class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1;i<=n;i++){
                if(i%2 == 0)
                    sb.append("박");
                else
                    sb.append("수");
            }
            return sb.toString();
        }
    }
}
