class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t<s.length; t++){
            String str = s[t];
            int one = 0;
            int count = 0;
            
            for(int i = 0; i<str.length(); i++){
                if(str.charAt(i) == '0'){
                    if(one >= 2){
                        one -= 2;
                        count++;
                    }
                    else{
                        if(one == 1){
                            sb.append(1);
                            one = 0;
                        }
                        sb.append(0);
                    }
                }
                else{
                    one++;
                }
            }
            while(count-- > 0){
                sb.append(110);
            }
            while(one-- > 0){
                sb.append(1);
            }
            answer[t] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}