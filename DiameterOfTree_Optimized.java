//Time complexity - O(n);

package Learning;

public class DiameterOfTree_Optimized {
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
    public static class TreeInfo{
        int height;
        int diameter;
        
        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
    public static TreeInfo diameterOfTree(Node root){
        if(root == null) return new TreeInfo(0, 0);
        
        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);
        
        int myHeight = Math.max(left.height, right.height) + 1;
        int d1 = left.diameter;
        int d2 = right.diameter;
        int d3 = left.height + right.height + 1;
        int myDiameter = Math.max(Math.max(d1, d2), d3);
        
        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
        return myInfo;
        
    }
    
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(diameterOfTree(root).diameter);
    }
}
