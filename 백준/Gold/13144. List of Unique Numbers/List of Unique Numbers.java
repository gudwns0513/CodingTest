import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static long count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 받은 수 저장
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[100001];

        for (int start = 0, end = 0; start < N; start++) {
            while (end < N && !visited[numbers[end]]) {
                visited[numbers[end++]] = true;
            }
            count += end - start;
            visited[numbers[start]] = false;
        }






        System.out.println(count);
    }

}
