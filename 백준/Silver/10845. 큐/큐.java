import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> queue = new ArrayList<Integer>();


        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")){
                queue.add(Integer.parseInt(st.nextToken()));
            }
            else if (cmd.equals("pop")){
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.remove(0));
            }
            else if (cmd.equals("size")){
                System.out.println(queue.size());
            }
            else if (cmd.equals("empty")){
                if (queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if (cmd.equals("front")){
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.get(0));
            }
            else {
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.get(queue.size()-1));
            }
        }
    }
}
