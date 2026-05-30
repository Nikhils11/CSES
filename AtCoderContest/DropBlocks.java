import java.util.*;
import java.io.*;

class Main{

    public static void main(String[]args) throws IOException{
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        String [] input = red.readLine().split(" ");
        int length = Integer.parseInt(input[0]);
        int queries = Integer.parseInt(input[1]);
        int offSet  = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (queries > 0){
            String [] typeQueries = red.readLine().split(" ");
            int type = Integer.parseInt(typeQueries[0]);
            int query = Integer.parseInt(typeQueries[1]);
            if (map.size() >= length){
                reSize(map);
            }
            if (type == 1){
                typeOne(map, query);
            }else{
                System.out.println(typeTwo(map, query));
            }
            queries--;
        }
    }

    public static void reSize(Map<Integer, Integer> map){
        int length = map.size();
        for (int value = 0; value < map.size(); value++){
            if (map.containsKey(value) && map.get(value) - 1 <= 0){
                map.remove(value);
            }else{
                map.put(value, map.get(value) - 1);
            }
        }
    }

    public static int typeTwo(Map<Integer, Integer> map, int compreTo){
        int count = 0;
        for (int value : map.keySet()){
            if (map.get(value) >= compreTo){
                count++;
            }
        }
        return count;
    }

    public static void typeOne(Map<Integer, Integer> map, int index){
        map.put(index,  map.getOrDefault(index, 0) + 1);
    }

}
