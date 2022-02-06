package Programmers;

class OneTwoFour_Prog {
    public String solution(int n) {
        int num = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            num = n % 3;
            n = n / 3;
            
            if(num == 0){
                num = 4;
                n -= 1;
            }
            sb.insert(0, num);
        }
        
        return sb.toString();
    }
}