import java.util.*;
import java.io.*;

class TwoSet{
    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        StringBuilder set1 = new StringBuilder();
        StringBuilder set2 = new StringBuilder();
        int count1 = 0;
        int count2 = 0;
        if (n % 4 == 0){
            int i = 1;
            int j = 2;
            int r = n;
            while (i < r){
                set1.append(i+ " ");
                set1.append(r + " ");
                set2.append(i + 1 + " ");
                set2.append(r - 1 + " ");
                i+=2;
                r -= 2;
                count1 += 2;
                count2 += 2;
            }
            System.out.println("YES");
            System.out.println(count1);
            set1.deleteCharAt(set1.toString().length() - 1);
            System.out.println(set1.toString());
            set2.deleteCharAt(set2.toString().length() - 1);
            System.out.println(count2);
            System.out.println(set2.toString());
        }else if (n % 4 == 3){
            set1.append(1 + " ");
            set1.append(2 + " ");
            set2.append(3 + " ");
            count1 = 2;
            count2 = 1;
            int i = 4;
            int r = n;
            while (i < r){
                set1.append(i + " ");
                set1.append(r + " ");
                set2.append(i + 1 + " ");
                set2.append(r - 1 + " ");
                i += 2;
                r -= 2;
                count1 += 2;
                count2 += 2;
            }
            System.out.println("YES");
            System.out.println(count1);
            set1.deleteCharAt(set1.toString().length() - 1);
            System.out.println(set1.toString());
            set2.deleteCharAt(set2.toString().length() - 1);
            System.out.println(count2);
            System.out.println(set2.toString());
        }else{
            System.out.println("NO");
        }
    }
}