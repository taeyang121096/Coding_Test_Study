public class StringBasic_Pro {
    class Solution {
        public boolean solution(String s) {
            int start = '0';
            int end = '9';
            if(s.length() == 4 || s.length() == 6){
                for(char c : s.toCharArray()){
                    if(c<start || c>end)
                        return false;
                }
            }
            else
                return false;

            return true;
        }
    }
}
