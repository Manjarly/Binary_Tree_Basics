//Will work on leetcode
package Learning;

public class SubTree {
    public static class Node{
        int data;
        Node right;
        Node left;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
            index++;
            if(nodes[index] == -1) return null;
            
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
    }
    public static boolean isIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.data == subRoot.data) return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        return false;
    }
    public static boolean isSubTree(Node root, Node subRoot){
        if(subRoot == null) return true;
        if(root == null) return false;
        
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)) return true;
            
        }
        
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] subNodes = {1,2,4,-1, -1, 5};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        
        BinaryTree subTree = new BinaryTree();
        Node subRoot = subTree.buildTree(subNodes);
        boolean result = isSubTree(root, subRoot);
        System.out.println(result);
    }
}
