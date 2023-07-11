package BinarySearchTree;
import java.util.*;
public class BSTSearch_RangePrint{
    static class Node{
        int data;
        Node left;
        Node right;
//constructor
         Node(int data){
        this.data = data;
    }
    }

   

    public static Node insert (Node root, int val){ //return type node isliye rakha gya hai recursively insert krenge value ko hum jha pr bhi root ko insert krnege finaly return krenge
//comparison
        if(root == null){
            root = new Node(val);
            return root;
        }
//compparison for duplicates value
        if(root.data >val){
        //left subtree
        root.left=insert(root.left, val);
    }
    else
    {
        root.right = insert(root.right, val);
    }
    return root;
}

    public static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){ // O(H)
        if(root == null){
            return false;
        }

        if(root.data>key){ //leftsubtree
            return search(root.left, key);
        }

        else if(root.data == key){
            return true;
        }
        else{
            return search(root.right, key);
        }
    }
//range
    public static void printINRange(Node root, int X, int Y){
        if(root == null){
            return;
        }
        if(root.data >= X && root.data<= Y){
            printINRange(root.left, X, Y);
            System.out.println(root.data+" ");
            printINRange(root.right, X, Y);
        }else if(root.data>=Y){
            printINRange(root.left, X, Y);
        }else{
            printINRange(root.right, X, Y);
    }
}
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer>path){
        if(root == null){
            return;
        }

        path.add(root.data);

        //leaf
        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);

    
    }
    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();

        // if(search(root, 18)){
        //     System.out.println("found");
        // }else{
        //     System.out.println("not found");
        // }

        // printINRange(root, 3, 12);
        printRoot2Leaf(root, new ArrayList<>());
    }

}
