package basic;
import java.io.*;
import java.util.StringTokenizer;

public class TreeLeveWidth {
    static class Node{
        int num;
        int parent;
        int left;
        int right;
        public Node(int num,int left,int right){
            this.num = num;
            this.parent = -1;
            this.left = left;
            this.right = right;
        }
    }
    static Node[] tree;
    static int[]min;
    static int[]max;
    static int index = 1;
    static void inorder(int root,int level){
        if(tree[root].left != -1)
            inorder(tree[root].left,level+1);
        min[level] = Math.min(min[level],index);
        max[level] = Math.max(max[level], index);
        index++;
        if(tree[root].right != -1)
            inorder(tree[root].right,level+1);
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        min = new int[n+1];
        max = new int[n+1];
        for(int i = 0;i<=n;i++){
            tree[i] = new Node(i,-1,-1);
            min[i] = n;
            max[i] = 0;
        }
        for(int i = 1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[num].left = left;
            tree[num].right = right;
            if(left != -1)
                tree[left].parent = num;
            if(right != -1)
                tree[right].parent = num;
        }
        int root = 0;
        for(int i = 1;i<=n;i++){
            if(tree[i].parent == -1) {
                root = i;
                break;
            }
        }
        inorder(root,1);
        int level =1;
        int width = 0;
        for(int i =0;i<=n;i++){
            if(width<max[i]-min[i]){
                level = i;
                width = max[i]-min[i];
            }

        }
        System.out.println(level+" "+(width+1));

    }

}
