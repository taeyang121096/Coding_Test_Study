/**
 * 2019 KAKAO BLIND RECRUITMENT 길 찾기 게임
 */

package kakao;
import java.util.*;
public class findroad {
class Solution {
    int answer[][];
    int num=0;
    class node{
        int x;
        int y;
        int index;
        node left;
        node right;
        public node(int x, int y, int index){
            this.x =x;
            this.y=y;
            this.index=index;
        }
    }
    public void connection(node root, node child){
        if(root.x>child.x){
            if(root.left == null) root.left = child;
            else connection(root.left, child);
        }else{
            if(root.right == null) root.right=child;
            else connection(root.right, child);
        }
    }
    
    void pre(node root){
        if(root==null) return;
        answer[0][num++] = root.index;
        pre(root.left);
        pre(root.right);
    }
    
    void post(node root){
        if(root==null) return;
        post(root.left);
        post(root.right);
        answer[1][num++]=root.index;
    }
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<node> list = new ArrayList<>();
        answer = new int[2][nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            list.add(new node(nodeinfo[i][0], nodeinfo[i][1], i+1));
            
        }
        
        Collections.sort(list, new Comparator<node>(){
           public int compare(node o1, node o2){
               if(o1.y == o2.y){
                   return o2.x-o1.x;
               }else{
                   return o2.y-o1.y;
               }
                   
           } 
        });
                
        for(int i=1; i<list.size(); i++){
            connection(list.get(0), list.get(i));
        }
        
        pre(list.get(0));
        num=0;
        post(list.get(0));
        
        
        return answer;
    }
}
}
