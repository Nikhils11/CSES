import java.util.*;
import java.io.*;

public class CoinCombination2{

//    private Set<Integer> map = new HashSet<>();
    private static int mod = 1000_000_007;
//    private static int count = 0;

    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = reader.readLine().split(" ");
        int length = Integer.parseInt(inputs[0]);
        int totalMoney = Integer.parseInt(inputs[1]);
        String [] initalCoins = reader.readLine().split(" ");
        int [] coins = new int[length];
        for (int i = 0; i < length; i++){
            coins[i] = Integer.parseInt(initalCoins[i]);
        }
        Set<Integer> map = new HashSet<>();
//        topDown(coins, 0, totalMoney, map);
        int count = bottomUp(coins, totalMoney);
        System.out.println(count);
    }


//    public static void topDown(int [] coins, int currMoney, int totalMoney, Set<Integer> map){
//        if (currMoney > totalMoney){
//            return;
//        }
////        int count = 0;
//        for (int coin : coins){
//           if (currMoney + coin == totalMoney && !map.contains(currMoney)){
//               count++;
//               map.add(currMoney);
//           }
//           topDown(coins, currMoney + coin, totalMoney, map);
//        }
////        return count;
//    }

    public static int bottomUp(int [] coins, int totalMoney){
        int [] dp = new int[totalMoney + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++){
            for (int sum = 1; sum <= totalMoney; sum++){
                if (sum - coins[i] >= 0 && dp[sum - coins[i]] > 0){
                    dp[sum] = (dp[sum] + dp[sum - coins[i]]) % mod;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[totalMoney];
    }

}