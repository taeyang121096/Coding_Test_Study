import java.util.*;

class Solution {
    
    class Trie{
        
        Trie[] child = new Trie[26];
        int count=0;
        
        int a = Character.getNumericValue('a');
        
        void insert(String str){
            Trie curr = this;
            for(char ch : str.toCharArray()){
                curr.count++;
                int idx = Character.getNumericValue(ch)-a;
                if(curr.child[idx] == null)
                    curr.child[idx] = new Trie();
                
                curr = curr.child[idx];
                
            }
            curr.count++;
        }
    
        
        int search(String str){
            Trie curr = this;
            for(char ch : str.toCharArray()){
                if(ch=='?') return curr.count;
                curr = curr.child[Character.getNumericValue(ch) - a];
                if(curr == null)
                    return 0;
            }
            return 0;
        }
    }
    
    
    Trie[] TrieRoot = new Trie[10000];
    Trie[] ReTrieRoot = new Trie[10000];
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int ansindx = 0;
        
        for(String str : words){
            int idx = str.length()-1;
            if(TrieRoot[idx] == null){
                TrieRoot[idx] = new Trie();
                ReTrieRoot[idx] = new Trie();
            }
            TrieRoot[idx].insert(str);
            str = new StringBuilder(str).reverse().toString();
            ReTrieRoot[idx].insert(str);
        }
        
        for(String str : queries){
            int idx = str.length()-1;
            if(TrieRoot[idx] == null){
                answer[ansindx++] = 0;
            continue;
            }
        
        if(str.charAt(0) != '?'){
            answer[ansindx++] = TrieRoot[idx].search(str);
        }
        else{
            str = new StringBuilder(str).reverse().toString();
            answer[ansindx++] = ReTrieRoot[idx].search(str);
        }
    }
        
        return answer;
    }
}