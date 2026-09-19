import java.util.*;
import java.io.*;


class MinCoin{

//    static int min = Integer.MAX_VALUE;
    static int callCount = 0;

    public static void main(String[]args) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        String [] input = red.readLine().split(" ");
        int [] coins = new int[Integer.parseInt(input[0])];
        int totalMoney = Integer.parseInt(input[1]);
        String [] array = red.readLine().split(" ");
        for (int i = 0; i < array.length; i++){
            coins[i] = Integer.parseInt(array[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(bottomUp(totalMoney, coins));
//        System.out.println(map.get(totalMoney));
//        System.out.println(Arrays.toString(coins));
//        System.out.println(totalMoney);
    }

    public static int countCombination(int [] coins, int currMoney, int count,
                                Map<Integer, Integer> map){
        if (currMoney < 0){
            return -1;
        }
        if (currMoney == 0){
//            System.out.println("Insise money Zero"
            return 0;
        }
        if (map.containsKey(currMoney)){
            return map.get(currMoney);
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++){
            int result = countCombination(coins, currMoney - coins[i], count + 1, map);
            if (result >= 0){
                minCount = Math.min(minCount, result + 1);
            }
        }
        int ans = 0;
        if (minCount == Integer.MAX_VALUE){
            ans = -1;
        }else{
            ans = minCount;
        }
        map.put(currMoney, ans);
        return ans;
    }


    public static int bottomUp(int totalMoney, int [] coins){
        int [] res = new int[totalMoney + 1];
        for (int i = 1;i <= totalMoney; i++){
            res[i] = Integer.MAX_VALUE;
        }
        for (int sum = 1; sum <= totalMoney; sum++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins){
                if (sum - coin >= 0 && res[sum - coin] != Integer.MAX_VALUE){
                    min = Math.min(min, res[sum - coin] + 1);
                }
            }
            res[sum] = min;
        }
//        System.out.println(Arrays.toString(res));
//        for (int value : res){
//            if (value > 3 && value != Integer.MAX_VALUE){
//                System.out.println(true + " "+ value);
//            }
//        }
        if (res[totalMoney] == Integer.MAX_VALUE){
            return -1;
        }
//        System.out.println(res[0]);
        return res[totalMoney];
    }

}