import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


// 배수판정법을 활용한 그리디
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Character[] arr = new Character[input.toCharArray().length];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = input.toCharArray()[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        // 10배수 검사
        boolean flag = false;
        int sum = 0; // 3배수 검사
        for (char c : arr) {
            if(c == '0') flag = true;
            sum += c - '0';
            sb.append(c);
        }
        if(!flag) {
            System.out.println("-1");
            return;
        }

        if(sum % 3 == 0) {
            System.out.println(sb.toString());
        } else {
            System.out.println("-1");
        }

        br.close();
        bw.close();
    }
}

