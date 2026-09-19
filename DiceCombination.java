import java.util.*;
import java.io.*;

class DiceCombination{

    static int mod = 1000_000_007;
    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[]args) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.valueOf(red.readLine());
        int [] ans = new int[target + 1];
        ans[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 1;j <= 6; j++){
                if (j > i){
                    break;
                }
                ans[i] += ans[i - j];
                ans[i] %= mod;
            }
        }
        System.out.println(ans[target]);
    }

    public static long findCombinationNumber(int target){
        if (map.containsKey(target)){
            return map.get(target);
        }
        if (target < 0){
            return 0;
        }
        if (target == 0){
            return 1;
        }
        long res = (findCombinationNumber(target - 1) % mod +
                findCombinationNumber(target - 2) % mod+
                findCombinationNumber(target - 3) % mod+
                findCombinationNumber(target - 4) % mod+
                findCombinationNumber(target - 5) % mod+
                findCombinationNumber(target - 6) % mod) % mod;
        map.put(target, res);
        return res;

    }


}