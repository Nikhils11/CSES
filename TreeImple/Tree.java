import java.util.*;

class Tree{

    static TreeNode root;

    public Tree(){
        this.root = null;
    }

    public static void main(String[]args){
        Tree tree = new Tree();
        tree.insert(100);
        System.out.println(tree);
        tree.insert(10);
        tree.insert(120);
        tree.insert(110);
        System.out.println("");
        System.out.println(tree);
        TreeNode curr = getRoot();
        System.out.println(curr);
        boolean isFalse = findNodeBol(curr, 120);
        System.out.println(isFalse);


    }

    public static TreeNode getRoot(){
        return root;
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

    public static TreeNode findNode(TreeNode head, int val){
        if (head == null){
            return null;
        }
        if (head.val == val){
            return head;
        }
        TreeNode temp1 = findNode(head.left, val);
        if (temp1 != null){
            return temp1;
        }
        TreeNode temp2 = findNode(head.right, val);
        if (temp2 != null){
            return temp2;
        }
        return null;
    }

    public static boolean findNodeBol(TreeNode head, int val){
        if (head == null){
            return false;
        }
        if (head.val == val){
            return true;
        }
        return findNodeBol(head.left, val) || findNodeBol(head.right, val);
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