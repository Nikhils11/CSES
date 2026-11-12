import java.util.*;
import java.io.*;


class RemoveDigits{

    static int min = Integer.MAX_VALUE;

    public static void main(String [] agrs) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(red.readLine());
        int [] dp = new int[num + 1];
        for (int i = 0; i <= num; i++){
            dp[i] = Integer.MAX_VALUE;
        }
//        System.out.println(numberOfDigitsToRemove(num, dp));
        System.out.println(bottomUp(num));
//        System.out.println(Arrays.toString(dp));
    }

    public static int numberOfDigitsToRemove(int num, int [] dp){
       if (num == 0){
           return 0;
       }
       if (dp[num] != Integer.MAX_VALUE){
           return dp[num];
       }
       int count = 0;
       int temp = num;
       while (temp > 0){
           int mod = temp % 10;
           if (mod == 0){
               temp = temp / 10;
               continue;
           }
           count = numberOfDigitsToRemove(num - mod, dp) + 1;
           dp[num] = Math.min(count, dp[num]);
           temp = temp / 10;
       }
       return dp[num];
    }

    public static int bottomUp(int num){
        int [] dp = new int[num + 1];
        for (int i = 0; i <= num; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int value = 1; value <= num; value++){
            int temp = value;
            int count = 0;
            while (temp > 0){
                int mod = temp % 10;
                temp = temp / 10;
                if (mod == 0){
                    continue;
                }
                if (dp[value - mod] != Integer.MAX_VALUE){
                    count = dp[value - mod] + 1;
                }
                dp[value] = Math.min(count, dp[value]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[num];
    }

}