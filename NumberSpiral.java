import java.util.*;
import java.io.*;

class NumberSpiral{

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(br.readLine());
        StringBuilder rm = new StringBuilder();
        long res = 0;
        while (testCases > 0) {
            String [] split = br.readLine().split(" ");
            long x = Long.parseLong(split[0]);
            long y = Long.parseLong(split[1]);
            if (x <= y){
                if (y % 2 == 0){
                    y = y - 1;
                    long ans = y * y;
                    ans = ans - (x + 1);
                    res = ans;
                }else{
                    long ans = y * y;
                    ans = ans - (x);
                    res = ans;
                }
            }else{
                if (x % 2 == 0){
                    x = x - 1;
                    long ans = x * x;
                    ans = ans - (y + 1);
                    res = ans;
                }else{
                    long ans = x * x;
                    ans = ans - (y);
                    res = ans;
                }
            }
            rm.append(res);
            rm.append("\n");
            testCases--;
        }
        System.out.println(rm);
    }
}