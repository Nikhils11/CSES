import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]agrs) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(red.readLine());
        Set<String> set = new HashSet<>();
        int i = 0;
        int count = 0;
        while (i < input.length()){
            if (input.charAt(i) == 'C'){
                count += Math.min(i, input.length() - i - 1) + 1;
            }
            i++;
        }
       System.out.println(count);
    }
}