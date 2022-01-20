import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            if(input.charAt(0) == '.') break;
            Stack<Character> s = new Stack<>();
            boolean flag = true;
            for(int i = 0 ; i < input.length() ; i++) {
                if(input.charAt(i) == '(' || input.charAt(i) == '[') s.push(input.charAt(i));
                else if(input.charAt(i) == ')' || input.charAt(i) == ']') {
                    if(s.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        Character c = s.pop();
                        if(c == '(' && input.charAt(i) != ')') {
                            flag = false;
                            break;
                        }
                        if(c == '[' && input.charAt(i) != ']') {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag && s.size() <= 0) bw.write("yes\n");
            else bw.write("no\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
