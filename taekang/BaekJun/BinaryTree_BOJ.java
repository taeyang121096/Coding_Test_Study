package BaekJun;
import java.io.*;

public class BinaryTree_BOJ {

    // 노드 만들기
    static class node{

        String x;
        node left;
        node right;
        public node(){};
        public node(String x){
            this.x=x;
        }

    }

    // 트리 만들기
    static void searchnode(node root ,String parant, String left, String right){

        // 종료 조건
        if(root==null) return;

        // 부모노드를 찾았을 경우
        if(root.x.equals(parant))
        {
            // 자식 노드가 비어있는 경우가 아니라면
            if(!left.equals(".")){
                root.left = new node(left);
            }
            if(!right.equals(".")){
                root.right = new node(right);
            }
        }else{
            // 부모노드를 못찾았을 경우 왼쪽 자식과 오른쪽 자식으로 이동해서 다시 탐색
            searchnode(root.left, parant, left, right);
            searchnode(root.right, parant, left, right);
        }
    }

    static node Root = new node();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 트리 만들기
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");

            if(i==0) {
                Root = new node(input[0]);
                if(!input[1].equals(".")){
                    Root.left = new node(input[1]);
                }
                if(!input[2].equals(".")){
                    Root.right = new node(input[2]);
                }
            }else{
                searchnode(Root ,input[0], input[1], input[2]);
            }
        }

        // 전위 탐색
        preorder(Root);

        inorder(Root);

        postorder(Root);

    }


    //전위 탐색
    public static void preorder(node root){
        System.out.print(root.x);
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }

    public static void inorder(node root) {
        if(root.left != null) inorder(root.left);
        System.out.print(root.x);
        if(root.right != null) inorder(root.right);
    }
    public static void postorder(node root) {
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        System.out.print(root.x);
    }
}