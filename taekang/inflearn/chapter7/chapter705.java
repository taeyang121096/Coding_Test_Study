package inflearn.chapter7;

import java.io.*;
import java.util.*;

public class chapter705 {
    Node root;

    public void DFS(Node root) {
        if (root == null) return;
        else {
//            System.out.println(root.val + " "); // 전위 순회, 중왼오
            DFS(root.lt);
//            System.out.println(root.val + " "); // 중위 순회, 왼중오
            DFS(root.rt);
//            System.out.println(root.val + " "); // 후위 순회, 왼오중
        }
    }

    public static void main(String[] args) throws IOException {
        chapter705 tree = new chapter705();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }

    static class Node {
        int val;
        Node lt, rt;

        public Node(int val) {
            this.val = val;
            this.lt = null;
            this.rt = null;
        }
    }
}
