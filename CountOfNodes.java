// Time complexity - O(n);

package Learning;


public class CountOfNodes {
    public static class Node{
        int data;
        Node right;
        Node left;
        
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
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
    
    public static int countNode(Node root){
        if(root == null) return 0;
        int leftNodes = countNode(root.left);
        int rightNodes = countNode(root.right);
        return leftNodes + rightNodes + 1;
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        int result = countNode(root);
        System.out.println(result);
    }
}