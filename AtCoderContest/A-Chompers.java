import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        int n = Integer.parseInt(reader.readLine().trim());
        StringBuilder res = new StringBuilder(input);
        int i = 0;
        while(i < n){
            res.deleteCharAt(0);
            i++;
        }
        i = res.toString().length() - 1;
        while(n > 0){
            res.deleteCharAt(i);
            i--;
            n--;
        }
        System.out.println(res);
    }
}