import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long A;
    static long B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        System.out.println(bfs(A, B));
    }

    static int bfs(Long A, Long B) {
        if (A == B) { // 두 수가 같으면 1반환
            return 1;
        }
        Queue<Long> queue = new LinkedList<>();
        queue.offer(A);
        int count = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long num = queue.poll();
                long newA1 = num * 2;
                long newA2 = Long.parseLong(Long.toString(num) + "1");

                if (newA1 == B || newA2 == B) { //정답 반환
                    count++;
                    return count;
                }
                if(newA1 < B)
                    queue.offer(newA1);

                if(newA2 < B)
                    queue.offer(newA2);
            }

            count++;
        }
        return -1;
    }
}
