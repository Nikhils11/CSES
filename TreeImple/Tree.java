import java.util.*;

class Tree{

    static TreeNode root;

    public Tree(){
        this.root = null;
    }

    public static void main(String[]args){
        Tree tree = new Tree();
        TreeNode newNode = new TreeNode(42);
        int [] array = {42, 7, 19, 3, 25, 8, 15};
        for (int i = 0;i < array.length;i++){
            tree.insert(array[i]);
        }
        System.out.println(tree);
        TreeNode curr = root;
        tree.insert(43);
        TreeNode toDelete = tree.findNode(curr, 42);
        System.out.println(toDelete.val);
        tree.deleteNode(toDelete);
        System.out.println(tree);
        System.out.println("Root"+root.val);
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

    //Delete a Node methods
    /*There are three cases here:
    1.Case: When the node we are deleting have no child nodes
    2.Case: When the node we are deleting have one child node
    3.Case: When the node we are deleting have two child nodes
     */
    //This method is if we have refrence of the node want to delete
    public void deleteNode(TreeNode head){
        if (head == null){
            return;
        }
        //If the node is the root of a tree
        if (head == root){
            deleteHead();
            return;
        }
        //Case1
        //find parent of the node we want to delete
        TreeNode currRoot = this.root;
        TreeNode parent = findParent(currRoot, head);
        if (head.left == null && head.right == null){
        //find parent of the node and set the refrence to null
            if (parent.left == head){
                parent.left = null;
            }else{
                parent.right = null;
            }
            //Case2 if head has one child
        }else if ((head.left != null && head.right == null)
                    || (head.left == null && head.right != null)){
            if (head.left == null){
                if (parent.left == head){
                    parent.left = head.right;
                }else{
                    parent.right = head.right;
                }
            }else{
                if (parent.left == head){
                    parent.left = head.left;
                }else{
                    parent.right = head.left;
                }
            }
            //Case3 If head has two child
        }else{
            if (parent.left == head){
                parent.left = head.right;
            }else{
                parent.right = head.right;
            }
            TreeNode curr = head.right;
            while (curr.left != null){
                curr = curr.left;
            }
            curr.left = head.left;
        }
    }

    private TreeNode findParent(TreeNode root, TreeNode head){
        //Here we are assuming that the head node always exists
        if (root == null){
            return null;
        }
        if (root.left == head || root.right == head){
            return root;
        }
        TreeNode temp = findParent(root.left, head);
        if (temp != null){
            return temp;
        }
        temp = findParent(root.right, head);
        if (temp != null){
            return temp;
        }
        return null;
    }

    private void deleteHead(){
        if (root == null){
            return;
        }
        if (root.left == null){
            System.out.println("inside left");
            root = root.right;
        }else if (root.right == null){
            System.out.println("inside Right");
            root = root.left;
        }else{
            TreeNode curr = root.right;
            while (curr.left != null){
                curr = curr.left;
            }
            curr.left = root.left;
            root = root.right;
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