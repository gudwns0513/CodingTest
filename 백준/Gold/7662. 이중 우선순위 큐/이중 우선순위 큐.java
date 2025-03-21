import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());

            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")) map.put(num, map.getOrDefault(num, 0) + 1);
                else{
                    if(map.isEmpty()) continue;

                    if(num == -1) {
                        int min = map.firstKey();
                        if(map.get(min) == 1) map.remove(min);
                        else map.put(min, map.get(min) - 1);
                    }else {
                        int max = map.lastKey();
                        if(map.get(max) == 1) map.remove(max);
                        else map.put(max, map.get(max) - 1);
                    }
                }
            }
            System.out.println(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
            map.clear();
        }


    }

}
