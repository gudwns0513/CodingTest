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
    static int[] nums;
    static int[] operators;
    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        dfs(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int result) {

        if (depth == n - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                switch(i) {
                    case 0:
                        dfs(depth + 1, result + nums[depth + 1]);
                        break;
                    case 1:
                        dfs(depth + 1, result - nums[depth + 1]);
                        break;
                    case 2:
                        dfs(depth + 1, result * nums[depth + 1]);
                        break;
                    case 3:
                        if (result < 0) {
                            dfs(depth + 1, -1 * (-1 * result / nums[depth + 1]));
                        } else {
                            dfs(depth + 1, result / nums[depth + 1]);
                        }
                        break;
                }
                operators[i]++;
            }
        }

    }
}
