import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Character>> phone = new ArrayList<>();
        phone.add(List.of('1','.',',','?','!'));
        phone.add(List.of('2','A','B','C'));
        phone.add(List.of('3','D','E','F'));
        phone.add(List.of('4','G','H','I'));
        phone.add(List.of('5','J','K','L'));
        phone.add(List.of('6','M','N','O'));
        phone.add(List.of('7','P','Q','R','S'));
        phone.add(List.of('8','T','U','V'));
        phone.add(List.of('9','W','X','Y','Z'));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int index = input.charAt(0) - '0'; // 인덱스
        int count = 0; // 해당 인덱스의 횟수
        for(int i = 0 ; i < input.length() ; i++) {
            if(input.charAt(i) - '0' == index) {
                count++;
            } else {
                // 다르면 문자를 구해 결과에 더하고
                bw.write(phone.get(index - 1).get((count - 1) % phone.get(index - 1).size()) + "");
                // 새로 업데이트
                count = 1;
                index = input.charAt(i) - '0';
            }
        }
        if(count > 0) {
            bw.write(phone.get(index - 1).get((count - 1) % phone.get(index - 1).size()) + "");
        }

        br.close();
        bw.close();
    }
}
/*
2차원 어레이리스트 사용
초기화 작업 후
숫자를 i로 숫자의 횟수를 두번째 j로.
*/