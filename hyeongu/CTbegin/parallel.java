class Solution {
    static int answer = 0;
    static boolean[] check = new boolean[4];
    public int solution(int[][] dots) {
                
        combination(dots, 0);
        
        return answer;
    }
    public static void combination(int[][] dots, int depth){
        if(depth == 2){
            double num1 = 0;
            double num2 = 0;
            for(int i = 0; i<3; i++){
                if(check[i] == true){
                    for(int j = i + 1; j<4; j++){
                        if(check[j] == true){
                            num1 = gradient(i, j, dots);
                        }
                    }
                }
            }
            for(int i = 0; i<3; i++){
                if(check[i] == false){
                    for(int j = i + 1; j<4; j++){
                        if(check[j] == false){
                            num2 = gradient(i, j, dots);
                        }
                    }
                }
            }
            if(num1 == num2){
                answer = 1;
            }
        }
        
        for(int i = 0; i<4; i++){
            if(!check[i]){
                check[i] = true;
                combination(dots, depth+1);
                check[i] = false;
            }
        }
    }
    
    public static double gradient(int first, int secend, int[][] dots){
        int x = Math.abs(dots[first][0] - dots[secend][0]);
        int y = Math.abs(dots[first][1] - dots[secend][1]);
        
        if(x == 0)
            return -1;
        if(y == 0)
            return 0;
        return (double)y/x;
    }
}