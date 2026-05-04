
import java.util.*;

class Permutations{

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder evenS = new StringBuilder();
        StringBuilder oddS = new StringBuilder();
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println("1");
        } else if (n <= 3) {
            System.out.println("NO SOLUTION");
        } else {
            int odd = 1;
            int even = 2;
            int end = n;
            while (odd <= end && even <= end) {
                oddS.append(String.valueOf(odd) + " ");
                evenS.append(String.valueOf(even) + " ");
                odd += 2;
                even += 2;
            }
            if (n % 2 == 1){
                oddS.append(n + " ");
            }
        }
        if (n == 4) {
            System.out.println(evenS.toString()+oddS.toString());
        } else {
            System.out.println(oddS.toString() + evenS.toString());
        }
    }
}