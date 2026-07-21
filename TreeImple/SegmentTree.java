import java.util.*;
import java.io.*;


class SegmentTree{

    private static int [] arr;

    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n * 2];
        String [] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[n + i] =  Integer.parseInt(input[i]);
        }
        build(arr, n);
        System.out.println(Arrays.toString(arr));
        int x = Integer.parseInt(reader.readLine());
        int index = Integer.parseInt(reader.readLine());
        set(x, index + n);
        System.out.println(Arrays.toString(arr));
        System.out.println(query(1, 1, 5, 1 , n));
    }

    public static void set(int x, int i){
        arr[i] = x;
        i = i / 2;
        while (i > 0){
            arr[i] = arr[i * 2] + arr[i * 2 + 1];
            i /= 2;
        }
    }

    public static int query(int x, int leftX, int rightX, int leftRange, int rigthRange){
        if (rigthRange <= leftX || leftRange >= rightX){
            return 0;
        }
        if (leftRange >= leftX && rigthRange <= rightX){
            return arr[x];
        }
        int m = (leftRange + rigthRange) / 2;
        int sum1 = query(x * 2, leftX, rightX, leftRange, m);
        int sum2 = query(x * 2 + 1, leftX, rightX, m, rigthRange);
        return  sum1 + sum2;
    }

    public static void build(int [] arr, int n){
        for (int i = n - 1; i > 0; i--){
            arr[i] = arr[i * 2] + arr[i * 2 + 1];
        }
    }
}