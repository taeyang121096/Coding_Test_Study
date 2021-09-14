/**
 *  2019 KAKAO BLIND RECRUITMENT 길 찾기 게임
 */

package kakao.retry;
import java.util.*;
public class findroad { 
class Solution {
    ArrayList<node> arr = new ArrayList<>();
    int[][] answer;
    int index;
    class node{
        int x;
        int y;
        int index;
        node left;
        node right;
        public node(int x, int y, int index){
            this.x=x;
            this.y=y;
            this.index=index;
        }
    }
    
    public void make(node parent, node child){
        int px =parent.x;
        int cx=child.x;
        if(cx<px){
            if(parent.left==null){
                parent.left=child;
                return;
            }else{
                make(parent.left,child);
            }
        }else{
            if(parent.right==null){
                parent.right=child;
                return;
            }else{
                make(parent.right, child);
            }
        }
    
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        answer = new int[2][nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++)
            arr.add(new node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        
        Collections.sort(arr,new Comparator<node>(){
            public int compare(node o1, node o2){
                if(o2.y==o1.y) return o1.x-o2.x;
                return o2.y-o1.y;
            }
        });
        
               
        for(int i=1; i<nodeinfo.length; i++){   
            node parent = arr.get(0);          
            node child = arr.get(i);            
            make(parent,child);         
        }
        index=0;
        pre(arr.get(0));
        index=0;
        post(arr.get(0));
        
        
        return answer;
    }
    
    public void pre(node root){
        if(root==null) return;
        
        answer[0][index++]=root.index;
        pre(root.left);
        pre(root.right);
    }
    
    public void post(node root){
        if(root==null) return;
           
        post(root.left);
        post(root.right);
        answer[1][index++]=root.index;
    }
    
}
}
