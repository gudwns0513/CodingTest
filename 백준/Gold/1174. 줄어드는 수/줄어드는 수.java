import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간 복잡도
    제한시간 : 2초

    - 접근
    1.
 */

public class Main {
    static int n;
    static int[] arr;
    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        list = new ArrayList<>();
        dfs(0L, 0);
        Collections.sort(list);

        if (list.size() >= n) {
            System.out.println(list.get(n-1));
        }else{
            System.out.println(-1);
        }


    }

    private static void dfs(Long num, int depth) {

        if (!list.contains(num)) {
            list.add(num);
        }

        if (depth >= 10) {
            return;
        }

        dfs(num*10 + arr[depth], depth + 1);

        dfs(num, depth + 1);







    }
}
