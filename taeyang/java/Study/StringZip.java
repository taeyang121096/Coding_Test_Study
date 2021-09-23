import java.util.*;
public class StringZip {
    static int min = Integer.MAX_VALUE;
    class Solution {
        public int solution(String s) {
            if(s.length() == 1)
                return 1;

            int answer = 0;

            int size = s.length();
            for(int i = 1;i<=(size/2);i++){
                String tmp = "";
                String ans = "";
                int cnt = 0;
                for(int j = 0;j < size;j += i){
                    if(j+i > size){
                        if(cnt == 0)
                            ans += tmp;
                        else
                            ans += String.valueOf(cnt+1)+tmp;
                        tmp = s.substring(j,size);
                        cnt = -1;
                        break;
                    }
                    if(tmp.equals("")){
                        tmp += s.substring(j,j+i);
                        continue;
                    }
                    if(!tmp.equals(s.substring(j,j+i))){
                        if(cnt == 0)
                            ans += tmp;
                        else
                            ans += String.valueOf(cnt+1)+tmp;
                        tmp = s.substring(j,j+i);
                        cnt = 0;
                    }
                    else
                        cnt++;
                }
                if(cnt > 0)
                    ans += String.valueOf(cnt+1)+tmp;
                else if(cnt == 0)
                    ans += tmp;
                else
                    ans += tmp;
                min = Math.min(ans.length(),min);
            }

            return min;
        }
    }
}
