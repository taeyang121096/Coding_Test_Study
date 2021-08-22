import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int x,y,index;
        Node left, right;
        
        Node(int x, int y, int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }
        @Override
        public int compareTo(Node n){
            return n.y - this.y;
        }
        
    }
    static List<Node> list = new ArrayList<>();
    static int[][] answer;
    static int count = 0;
    
    void conn(Node root,Node child){
        if(root.x > child.x){
            if(root.left == null) root.left = child;
            else
                conn(root.left,child);
        }
        else{
            if(root.right == null) root.right = child;
            else
                conn(root.right,child);
        }
        
    }
//     ·ç ¿Þ ¿À
    void pre(Node root){
        if(root == null) return;
        answer[0][count++] = root.index;
        pre(root.left);
        pre(root.right);
    }
//     ¿Þ ¿À ·ç
    void post(Node root){
        if(root == null) return;
        post(root.left);
        post(root.right);
        answer[1][count++] = root.index;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        for(int i =0;i<nodeinfo.length;i++){
            list.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        Collections.sort(list);
        
        for(int i =1;i<list.size();i++){
            conn(list.get(0),list.get(i));
        }
        
        pre(list.get(0));
        count = 0;
        post(list.get(0));
        
        return answer;
    }
}