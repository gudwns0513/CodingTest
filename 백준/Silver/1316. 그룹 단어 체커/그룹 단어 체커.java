import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static boolean check(String str){
        ArrayList<Character> list = new ArrayList<>();
        char current = str.charAt(0);
        list.add(current);

        for(int i = 1; i < str.length(); i++){
            if(!list.contains(str.charAt(i)) || str.charAt(i) == current)
                list.add(str.charAt(i));
            else
                return false;
            current = str.charAt(i);
        }
        return true;


    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < num; i++){
            if(check(br.readLine())) count++;
        }


        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}
