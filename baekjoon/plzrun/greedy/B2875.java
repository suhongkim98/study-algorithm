import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int team = N / 2 > M ? M : N / 2; // 최대 만들 수 있는 팀
        int surplus = (N + M) - (team * 3); // 잉여

        if(surplus >= K) {
            bw.write(team + "");
        } else {
            K -= surplus;
            if(K <= 3) team--;
            else {
                int need = K / 3; // 빼야하는 팀
                team -= need;
                if(K % 3 != 0) team--; // 나누어 떨어지지 않으면 추가로 빼야함
            }
            bw.write(team + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
// 30
}
/*

남자가 핵심
일단 최대한 만들 수 있는 팀 개수를 구한다.
최대 만들었을 때 남는 사람 수도 구한다

남는 사람 수로 해결 가능하면 그대로 최대값 반환
그게 안된다면 만들 수 있는 팀 개수를 1 빼면 여유분이 3나온다
	즉 K가 3보다 작거나 같다면 만들 수 있는 팀 개수에서 1 빼서 반환
	아니라면 최대한 만들 수 있는 팀 개수에서 K / 3을 빼서 반환한다

 */
