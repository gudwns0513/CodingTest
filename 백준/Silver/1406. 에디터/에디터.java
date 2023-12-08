import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    public static void main(String args[]) throws IOException{
        Stack<Character> stL = new Stack<>();
		Stack<Character> stR = new Stack<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < str.length(); i++){
            stL.push(str.charAt(i));
        }
        
        for(int i = 0; i < n; i++){
            String command = br.readLine();
                if(command.equals("L")){
                    if(!stL.empty())
                        stR.push(stL.pop());
                }
                else if(command.equals("D")){
                    if(!stR.empty())
                        stL.push(stR.pop());
                }
                else if(command.equals("B")){
                    if(!stL.empty())
                        stL.pop();
                }
                else{
                    stL.push(command.charAt(2));
                }
            }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(!stL.empty()){
            stR.push(stL.pop());   
        }
        while(!stR.empty()){
            bw.write(stR.pop());
        }
        bw.flush();
		bw.close();
    }
}