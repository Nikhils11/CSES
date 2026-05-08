import java.util.*;
import java.io.*;

class Graph{

    static ListNode [] adjList;
    static ListNode [][] adjMatrix;

    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfVertex = Integer.valueOf(reader.readLine());
        adjList = new ListNode[numberOfVertex];
        adjMatrix = new ListNode[numberOfVertex][numberOfVertex];
        while (true){
            String input = reader.readLine();
            if (input.equals("")){
                break;
            }
            String [] vertex = input.split(" ");
            buildList(vertex, adjList);
        }
        System.out.println(printGraph());
        deleteEdge(2, 5);
        System.out.println("After Deletion");
        System.out.println(printGraph());
        addEdge(2, 5);
        System.out.println("After adding");
        System.out.println(printGraph());
    }

    public static void buildList(String [] vertex, ListNode[] list){
         int index = Integer.valueOf(vertex[0]);
        for (int i = 1;i < vertex.length;i++){
            int val = Integer.valueOf(vertex[i]);
            insertNode(list, val, index);
        }
    }

    //intertion and deletion opration
    //This is the insetation op
    private static void insertNode(ListNode [] list, int val, int index){
        ListNode newNode = new ListNode(val);
        if (list[index] == null){
            list[index] = newNode;
            return;
        }
        ListNode curr = list[index];
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public static void addEdge(int vertex1, int vertex2){
        ListNode curr = adjList[vertex1];
        if (checkEdgeExists(curr, vertex2)){
            return;
        }
        ListNode newNode = new ListNode(vertex2);
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public static boolean checkEdgeExists(ListNode curr, int vertex2){
        while (curr != null){
            if (curr.val == vertex2){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void deleteEdge(int vertex1, int vertex2){
        ListNode head = adjList[vertex1];
        if (head == null){
            return;
        }else if (head.val == vertex2){
            adjList[vertex1] = head.next;
            return;
        }
        deleteNode(head, vertex2);
    }

    private static void deleteNode(ListNode head, int val){
        ListNode curr = head;
        ListNode prev = head;
        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static String printGraph(){
        StringBuilder res = new StringBuilder();
        for (int i = 1;i < adjList.length;i++){
            ListNode curr = adjList[i];
            res.append(i + " ");
            while (curr != null){
                res.append(curr.val + " ");
                curr = curr.next;
            }
            res.append("\n");
        }
        return res.toString();
    }
}

class ListNode{

    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

}