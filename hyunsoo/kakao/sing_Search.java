/**
 * 2020 KAKAO BLIND RECRUITMENT 가사검색
 */
package kakao;
import java.util.*;
public class sing_Search { 
// 트라이 자료구조!!
class Solution {
    
    Trie[] trie = new Trie[10000];
    Trie[] retrie = new Trie[10000];
    
    class Trie{
        Trie[] child = new Trie[26];
        int count=0;

        void insert(String str){
            Trie curr=this;
            for(char c : str.toCharArray()){
                curr.count++;
                int index = c - 'a';
                if(curr.child[index]==null){
                    curr.child[index]=new Trie();
                }
                curr = curr.child[index];
            }
            curr.count++;
        }
            
        int search(String str){
            Trie curr = this;
            for(char c : str.toCharArray()){
                if(c=='?') return curr.count;
                curr=curr.child[c-'a'];
                if(curr==null) return 0;
            }
            return 0;
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
    
        int[] answer=new int[queries.length];
        int answeridx=0;
        
        for(String str : words){
            int idx = str.length()-1;
            if(trie[idx]==null){
                trie[idx]= new Trie();
                retrie[idx]=new Trie();
            }
            trie[idx].insert(str);
            str = new StringBuilder(str).reverse().toString();
            retrie[idx].insert(str);
        }
        
        for(String str : queries){
            int idx = str.length()-1;
            if(trie[idx]==null){
                answer[answeridx++]=0;
                continue;
            }
            if(str.charAt(0) != '?'){
                answer[answeridx++]=trie[idx].search(str);
            }else{
                str =new StringBuilder(str).reverse().toString();
                answer[answeridx++]=retrie[idx].search(str);
            }
        }
        
        return answer; 
    }
}
}


