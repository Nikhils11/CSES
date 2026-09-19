import java.util.*;
import java.io.*;

class CoinCombination{

    private static int count = 0;

    private static final int mod = 1_000_000_007;

    public static void main(String[]agrs) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" ");
        int length = Integer.parseInt(input[0]);
        int totalMoney = Integer.parseInt(input[1]);
        String [] coinsString = reader.readLine().split(" ");
        int [] coins = new int[length];
        for (int i = 0; i < length; i++){
            coins[i] = Integer.parseInt(coinsString[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
//        System.out.println(topDown(coins, totalMoney, map, 0));
//        System.out.println(map.get(0));
        System.out.println(bottomUp(coins, totalMoney));
    }

    public static int topDown(int [] coins, int totalMoney, Map<Integer, Integer> map, int currAmount){
        if (totalMoney == currAmount){
            return 1;
        }
        if (currAmount > totalMoney){
            map.put(currAmount, -1);
            return 0;
        }
        int countCurr = 0;
        for (int i = 0; i < coins.length; i++){
            boolean containKey = map.containsKey(currAmount + coins[i]);
            if (containKey && map.get(currAmount + coins[i]) == -1){
                return 0;
            }
            if (containKey && map.get(currAmount + coins[i]) > 0){
//                System.out.println(count + " inside map");
//                count = (count + map.get(currAmount + coins[i])) % mod;
                countCurr = (countCurr + map.get(currAmount + coins[i])) % mod;
                map.put(currAmount, countCurr);
//                System.out.println("inside map" + currAmount + " "+count);
                continue;
            }
            countCurr = (countCurr + topDown(coins, totalMoney, map, currAmount + coins[i])) % mod;
//            System.out.println("inside loop");
        }
//        System.out.println(currAmount + " " + countCurr);
        return countCurr;
    }

    public static int bottomUp(int [] coins, int totalMoney){
        int [] waysToMakeSum = new int[totalMoney + 1];
//        for (int i = 1; i < waysToMakeSum.length; i++){
//            waysToMakeSum[i] = -1;
//        }
        for (int sum = 1; sum < waysToMakeSum.length; sum++){
            for (int i = 0; i < coins.length; i++){
                if (sum - coins[i] == 0) {
                    waysToMakeSum[sum] = (waysToMakeSum[sum] + 1) % mod;
                }else if (sum - coins[i] > 0 && waysToMakeSum[sum - coins[i]] > 0){
                    waysToMakeSum[sum] = (waysToMakeSum[sum] + waysToMakeSum[sum - coins[i]]) % mod;
                }
            }
        }
//        System.out.println(Arrays.toString(waysToMakeSum));
        return waysToMakeSum[totalMoney];
    }

}