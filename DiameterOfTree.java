//Time complexity - O(n^2);
package Learning;

public class DiameterOfTree {
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
    public static int heightOfTree(Node root){
        if(root == null) return 0;
        
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static int diameterOfTree(Node root){
        if(root == null) return 0;
        int d1 = diameterOfTree(root.left);
        int d2 = diameterOfTree(root.right);
        int d3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(d3, Math.max(d1, d2));
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        int result = diameterOfTree(root);
        System.out.println(result);
    }
}
