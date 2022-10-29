class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            switch(n%3){
                case 0:
                    sb.append(4);
                    n-=3;
                    break;
                case 1:
                    sb.append(1);
                    break;
                case 2:
                    sb.append(2);
                    break;
            }
            n /= 3;
        }
        
        
        return sb.reverse().toString();
    }
}