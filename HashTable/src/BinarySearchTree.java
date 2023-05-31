public class BinarySearchTree {
    private TreeNode head;
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private class TreeNode{
        int value;
        boolean color;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(int value, boolean color){
            this.value=value;
            this.color=color;
        }
    }

    public void add(int value){
        head=add(head, value);
        head.color=BLACK;
    }

    private TreeNode add(TreeNode node, int value){
        if(node==null){
            return new TreeNode(value, RED);
        }
        if(value< node.value){
            node.left=add(node.left,value);
        } else if (value> node.value) {
            node.right=add(node.right, value);
        }else return node;

        if(isRed(node.right)&& !isRed(node.left.left)){
            node=rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node=rotateRight(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }

    private boolean find(int value){
        TreeNode currentNode=head;
        while (currentNode!=null){
            if(currentNode.value==value)return true;
            else if(value>currentNode.value){
                currentNode=currentNode.right;
            }
            else {
                currentNode=currentNode.left;
            }
        }
        return false;
    }

    private TreeNode rotateLeft(TreeNode node) {
        TreeNode x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private TreeNode rotateRight(TreeNode node) {
        TreeNode x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(TreeNode node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private boolean isRed(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }
}
