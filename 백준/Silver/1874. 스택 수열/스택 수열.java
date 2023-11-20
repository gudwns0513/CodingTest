import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] se = new int[n];
        char[] calc = new char[n*2];
        int calc_count = 0;
        int count = 1;
        int plus_count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            se[i] = Integer.parseInt(br.readLine());
        }
        for (int j = 0; j < n; j++){
            if (stack.empty()){
                stack.push(count++);
                calc[calc_count++] = '+' ;
                plus_count++;
            }
            while(stack.peek() != se[j]) {
                if (plus_count == n){
                    System.out.println("NO");
                    System.exit(0);
                }
                stack.push(count++);
                calc[calc_count++] = '+';
                plus_count++;
            }
            if (stack.peek() == se[j]){
                stack.pop();
                calc[calc_count++] = '-';
            }
        }

        if (calc_count == calc.length){
            for (char a : calc){
                System.out.println(a);
            }
        }
    }
}
