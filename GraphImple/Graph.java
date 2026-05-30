import java.util.*;
import java.io.*;

class Graph{

    static ListNode [] adjList;
    static ListNode [][] adjMatrix;
    static int numberOfVertex;

    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberOfVertex = Integer.valueOf(reader.readLine()) + 1;
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
        System.out.println("After Deletion");
        System.out.println(printGraph());
        System.out.println("After adding");
        System.out.println(printGraph());
        boolean [] discoverd = new boolean[numberOfVertex];
        int [] parent = new int[numberOfVertex];
        System.out.println(Arrays.toString(parent));
        System.out.println("TopologicalSort printing");
        boolean [] proccessed = new boolean[numberOfVertex];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < numberOfVertex - 1;i++) {
            topologicalSort(i, adjList, proccessed, discoverd, stack);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
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

    public static void bfs(int start, boolean [] discoverd, int [] parents){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        System.out.print(start+ " ");
        discoverd[start] = true;
        while (!queue.isEmpty()){
            int parent = queue.remove();
            ListNode curr = adjList[parent];
            while (curr != null){
                if (!discoverd[curr.val]){
                    //Over here we can procces edge (parent, curr.val
                    System.out.print(curr.val + " ");
                    discoverd[curr.val] = true;
                    queue.add(curr.val);
                    parents[curr.val] = parent;
                }
                curr = curr.next;
            }
            //Over here we can proccess a particular vertex parent
        }
    }

    public static void topologicalSort(int start, ListNode [] adjList,
                                boolean [] proccessed, boolean [] discoverd,
                                Stack<Integer> stack){
        ListNode curr = adjList[start];
        discoverd[curr.val] = true;
        while (curr != null){
            if (!discoverd[curr.val]){
                topologicalSort(curr.val, adjList, proccessed, discoverd, stack);
            }
            curr = curr.next;
        }
        stack.push(start);
        proccessed[start] = true;
    }

    public static boolean DFS(int start, ListNode[] adjList,
                           boolean [] discoverd, boolean [] proccesed, int [] parent){
        ListNode curr = adjList[start];
        discoverd[start] = true;
        System.out.print(start + " ");
        while (curr != null){
            if (!discoverd[curr.val]){
                parent[curr.val] = start;
                System.out.print("Parent:" + start + " Child:" + curr.val+" ");
                if (DFS(curr.val, adjList, discoverd, proccesed, parent)){
                    return true;
                }
            }else if(!proccesed[curr.val]){
            // do something with the edge
                if (detectCycle(parent, start, curr.val)){
                    return true;
                }
            }
            curr = curr.next;
        }
        proccesed[start] = true;
        System.out.println(" ");
        return false;
    }

    public static boolean detectCycle(int [] parents, int parent, int child){
        if (parents[parent] != child){
            System.out.println("Cycle detected due to:" + "/n"
                    + "Parent:"+parent + " Child:"+child+" ");
            return true;
        }
        return false;
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