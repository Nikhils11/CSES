import java.util.*;

class IncreassingArray{

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int index = 0;
        int prev = 0;
        int res = 0;
        while (index < sizeOfArray){
            int curr = scanner.nextInt();
            if (prev > curr){
                res += Math.abs(curr - prev);
            }
            prev = curr;
            index++;
        }
        System.out.println(res);
    }

}