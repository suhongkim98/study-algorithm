import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();
        String pattern = br.readLine();
        KMP kmp = new KMP();
        List<Integer> list = kmp.find(origin,pattern);
        bw.write(list.size() + "\n");
        for(int i = 0 ; i < list.size() ; i++) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
class KMP {

    // 우리는 패턴 전처리를 통해 매칭에 실패했을 때 돌아갈 곳을 미리 계산한다.
    // 패턴에서 접두사도 되고 접미사도 되는 문자열의 최대 길이를 저장해주는 table 을 생성한다.
    // table[]은 pattern 이 어디까지 일치했는지가 주어질 때 다음 시작 위치를 어디로 해야할지를 말해주기 때문에, 이를 흔히 부분 일치 테이블이라고 부른다.
    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i = 1; i < n; i++) {
            // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(idx)) {
                table[i] = ++idx;
            }
        }
        return table;
    }

    static List<Integer> find(String origin, String pattern) {
        int[] table = makeTable(pattern);

        int n1 = origin.length();
        int n2 = pattern.length();

        List<Integer> list = new ArrayList<>();

        int idx = 0; // 현재 대응되는 글자 수
        for (int i = 0; i < n1; i++) {
            // idx번 글자와 짚더미의 해당 글자가 불일치할 경우,
            // 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
            while (idx > 0 && origin.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            // 글자가 대응될 경우
            if (origin.charAt(i) == pattern.charAt(idx)) {
                if (idx == n2 - 1) {
                    list.add(i - idx + 1);
                    idx = table[idx];
                } else {
                    idx += 1;
                }
            }
        }
        return list;
    }
}
