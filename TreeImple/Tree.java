import java.util.*;

class Tree{

    TreeNode root;

    public Tree(){
        this.root = null;
    }

    public static void main(String[]args){
        Tree tree = new Tree();
        tree.insert(100);
        System.out.println(tree);
        tree.insert(10);
        System.out.println("");
        System.out.println(tree);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        TreeNode currHead = this.root;
        inOrderTraversel(currHead, res);
        return res.toString();
    }

    private void inOrderTraversel(TreeNode head, StringBuilder res){
        if (head == null){
            return;
        }
        inOrderTraversel(head.left, res);
        res.append(head.val + " ");
        inOrderTraversel(head.right, res);
    }

    private TreeNode findNodeToInsert(TreeNode curr, int val){
        if (curr == null){
            return null;
        }
        if (curr.val >= val && curr.left == null){
            return curr;
        }
        if (curr.val < val && curr.right == null){
            return curr;
        }
        if (curr.val > val){
            TreeNode temp = findNodeToInsert(curr.left, val);
            if (temp != null){
                return temp;
            }
        }else{
            TreeNode temp = findNodeToInsert(curr.right, val);
            if (temp != null){
                return temp;
            }
        }
        return null;
    }


    public void insert(int val){
        TreeNode newNode = new TreeNode(val);
        if (root == null){
            root = newNode;
            return;
        }
        TreeNode curr = root;
        TreeNode toInsertInto = findNodeToInsert(curr, val);
        if (toInsertInto.val >= val){
            toInsertInto.left = newNode;
        }else{
            toInsertInto.right = newNode;
        }
    }


}
class TreeNode{

    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
}