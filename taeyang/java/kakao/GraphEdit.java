import java.util.*;
class Solution {

    static Stack<Integer> stack = new Stack<>();
    static int K =0;
    static int N = 0;

    void change(String c){
        if(c.equals("C")){
            stack.push(K);
            N--;
            if(K==N)
                K--;
        }else{
            if(stack.pop() <= K)
                K++;
            N++;

        }
    }


    void move(String c, int val ){
        if(c.equals("D")){
            K += val;
        }else{
            K -= val;
        }
    }

    public String solution(int n, int k, String[] cmd) {

        N = n;
        K = k;

        for(String s : cmd){
            if(s.equals("C") || s.equals("Z"))
                change(s);
            else{
                move(s.split(" ")[0],Integer.parseInt(s.split(" ")[1]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++)
            sb.append("O");
        while(!stack.isEmpty())
            sb.insert(stack.pop(),"X");

        return sb.toString();
    }
}