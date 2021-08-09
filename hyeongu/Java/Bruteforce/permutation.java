import java.util.*;
//소수 찾기
class Solution {
    static int answer = 0;
    static boolean[] check = new boolean[7];
    static ArrayList<Integer> arr = new ArrayList<>();
    
    //주어진 숫자로 만들수있는 조합의 배열
    public static void permutation(String n,String temp,int len){
        if(temp.length() == len) {
            if(!arr.contains(Integer.parseInt(temp))) arr.add(Integer.parseInt(temp));              
            return;
        }
        
        for(int j =0;j<n.length();j++){
            if(check[j]) continue;
            temp += n.charAt(j);
            check[j] = true;
            permutation(n,temp,len);
            check[j] = false;
            temp = temp.substring(0,temp.length()-1);
        }                      
    }
    //소수인지 아닌지 판별
    public static void prime(int n){
        if(n == 0) return;
        if(n == 1) return;
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return;
        }
        answer++;
    }
    //Main
    public int solution(String numbers) { 
        String temp="";
        
        for(int i = 1;i<=numbers.length();i++){
            permutation(numbers,temp,i);
        }
        
        for(int x : arr){            
            prime(x);
        }
        return answer;
    }
}