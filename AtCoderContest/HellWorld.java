import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]agrs) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder("HelloWorld");
        int input = Integer.parseInt(reader.readLine());
        res.deleteCharAt(input - 1);
        System.out.println(res);
    }
}