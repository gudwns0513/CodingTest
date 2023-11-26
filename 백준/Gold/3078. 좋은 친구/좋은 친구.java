import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long count = 0;

        Queue<Integer>[] friends = new Queue[21];
        for (int i = 0; i < 21; i++) {
            friends[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            int length = br.readLine().length();
            if (friends[length].isEmpty()) {
                friends[length].offer(i);
                continue;
            }
            while(!friends[length].isEmpty()) {
                if(i-friends[length].peek()<=K) {
                    // 첫번째 값이 된다면 아래있는 뒷번호는 다가능하다 그래서더해줌
                    count += friends[length].size();
                    break;
                }
                friends[length].poll();
            }
            friends[length].offer(i);
        }

        System.out.print(count);
    }
}
