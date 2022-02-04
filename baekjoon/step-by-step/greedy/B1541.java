import java.io.*;
import java.util.*;


//  그때그때 항상 최적화된 값 사용하는 그리디 알고리즘
//'-'문자을 만나면 그 뒤는 모두 음수로 계산하는게 최적임 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int startIdx = 0;
        boolean isPositive = true;
        int result = 0;
        for(int i = 0 ; i <= input.length() ; i++) {
            if(i == input.length() || input.charAt(i) == '+' || input.charAt(i) == '-') {
                int n = Integer.parseInt(input.substring(startIdx, i));
                if (isPositive) result += n;
                else result -= n;

                startIdx = i + 1;
                if(i != input.length() && input.charAt(i) == '-') isPositive = false;
            }
        }

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

