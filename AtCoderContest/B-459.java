import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        String [] array = input.split(" ");
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < array.length; i++){
            String s = array[i];
            if (s.length() <= 0){
                continue;
            }
            if (checkFirst(s)){
                    res.append("2");
            }else if (checkSecond(s)){
                    res.append("3");
            }else if (checkThird(s)){
                    res.append("4");
            }else if (checkFourth(s)){
                    res.append("5");
            }else if (checkFifth(s)){
                    res.append("6");
            }else if (checkSixth(s)){
                    res.append("7");
            }else if (checkSeventh(s)){
                    res.append("8");
            }else if (checkEigth(s)){
                res.append("9");
            }
        }
        System.out.println(res);
    }

    public static boolean checkFirst(String s){
        if (s.charAt(0) == 'a'
            || s.charAt(0) == 'b'
            || s.charAt(0) == 'c'){
            return true;
        }
        return false;
    }

    public static boolean checkSecond(String s){
        if (s.charAt(0) == 'd'
                || s.charAt(0) == 'e'
                || s.charAt(0) == 'f'){
            return true;
        }
        return false;
    }

    public static boolean checkThird(String s){
        if (s.charAt(0) == 'g'
                || s.charAt(0) == 'h'
                || s.charAt(0) == 'i'){
            return true;
        }
        return false;
    }

    public static boolean checkFourth(String s){
        if (s.charAt(0) == 'j'
                || s.charAt(0) == 'k'
                || s.charAt(0) == 'l'){
            return true;
        }
        return false;
    }

    public static boolean checkFifth(String s){
        if (s.charAt(0) == 'm'
                || s.charAt(0) == 'n'
                || s.charAt(0) == 'o'){
            return true;
        }
        return false;
    }

    public static boolean checkSixth(String s){
        if (s.charAt(0) == 'p'
                || s.charAt(0) == 'q'
                || s.charAt(0) == 'r'
                || s.charAt(0) == 's'){
            return true;
        }
        return false;
    }

    public static boolean checkSeventh(String s){
        if (s.charAt(0) == 't'
                || s.charAt(0) == 'u'
                || s.charAt(0) == 'v'){
            return true;
        }
        return false;
    }

    public static boolean checkEigth(String s){
        if (s.charAt(0) == 'w'
                || s.charAt(0) == 'x'
                || s.charAt(0) == 'y'
                || s.charAt(0) == 'z'){
            return true;
        }
        return false;
    }
}