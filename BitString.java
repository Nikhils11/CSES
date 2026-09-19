import java.util.*;
import java.io.*;

class BitString{
    static int mod = 1_000_000_007;
    public static void main(String [] args) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(red.readLine());
        System.out.println(power(n, 2L));
    }

   public static long power(int n, long current){
        if (n == 0){
            return 1;
        }
        if (n % 2 == 0){
            return power(n / 2, (current * current) % mod);
        }else{
            return (power((n - 1) / 2, (current * current) % mod) * current) % mod;
        }
   }
}