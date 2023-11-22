import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Stack_arr{
    private ArrayList<Integer> arr = new ArrayList<>();
    private int top;

    public Stack_arr(int n){
        top = -1;
    }
    public void push(int n){
        arr.add(n);
        top++;
    }

    public int pop(){
        if (this.top == -1)
            return top;
        return arr.remove(top--);
    }

    public int size(){
        return arr.size();
    }

    public int empty(){
        if (arr.size() == 0)
            return 1;
        else
            return 0;
    }

    public int top(){
        if (top == -1)
            return top;
        return arr.get(top);
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack_arr stack = new Stack_arr(n);

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));
            else if (str.equals("pop"))
                System.out.println(stack.pop());
            else if (str.equals("size"))
                System.out.println(stack.size());
            else if (str.equals("empty"))
                System.out.println(stack.empty());
            else
                System.out.println(stack.top());

        }
    }
}

