import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        HashMap<String, Integer>result = new HashMap<>();
        // 주어진 배열을 sort
        Arrays.sort(phone_book);
        
        // 배열이 정렬되어 있기 때문에 뒤에 있는 값은 고려하지 않아도 됨
        // hash에 삽입하면서 기존에 삽입된 key값들과 비교
        for(int i = 0; i<phone_book.length;i++){
            result.put(phone_book[i], i);
            for(int j=1; j<phone_book[i].length();j++){
                if(result.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return true;
    }
}