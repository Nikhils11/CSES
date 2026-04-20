import java.util.*;

class IncreassingArray{

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int index = 0;
        long prev = 0;
        long res = 0;
        while (index < sizeOfArray){
            long curr = scanner.nextLong();
            if (prev > curr){
                res += Math.abs(curr - prev);
            }else{
                prev = curr;
            }
            index++;
        }
        System.out.println(res);
    }

}