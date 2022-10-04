import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int count = 0;
        // 가로 방향으로 탐색
        for(int i = 0 ; i < N ; i++) {
            boolean[] bridge = new boolean[N];
            int before = map[i][0]; // 이전값
            boolean flag = true;
            for(int j = 0 ; j < N ; j++) {
                if(Math.abs(before - map[i][j]) > 1) {
                    flag = false;
                    break; // 길이가 2차이 이상 차이 남
                }
                // 커->작인경우, ->로 다리를 깔며 검사
                if(before - map[i][j] > 0) {
                    // L 횟수만큼 다리를 깐다.
                    int bCount = 0;
                    int bVal = map[i][j]; // 다리 설치 값
                    for(int k = j ; k < N && bCount != L ; k++) {
                        if(bridge[k] || bVal != map[i][j]) {
                            flag = false; // 이미 다리가 깔려있음
                            break;
                        }
                        bridge[k] = true; // 다리설치
                        bCount++;
                    }
                    if(bCount != L) { // 다리를 충분히 설치못함
                        flag = false;
                        break;
                    }
                } else if(before - map[i][j] < 0) {
                    // 작->커인경우 <- 로 다리를 깔며 검사
                    // L 횟수만큼 다리를 깐다.
                    int bCount = 0;
                    int bVal = map[i][j]; // 다리 설치 값
                    for(int k = j - 1 ; k >= 0 && bCount != L ; k--) {
                        if(bridge[k] || bVal != map[i][j]) {
                            flag = false; // 이미 다리가 깔려있음
                            break;
                        }
                        bridge[k] = true; // 다리설치
                        bCount++;
                    }
                    if(bCount != L) { // 다리를 충분히 설치못함
                        flag = false;
                        break;
                    }
                }
                before = map[i][j];
            }
            if(flag) {
                // 성공
                count++;
            }

        }

        // 세로 방향으로 탐색
        for(int i = 0 ; i < N ; i++) {
            boolean[] bridge = new boolean[N];
            int before = map[0][i]; // 이전값
            boolean flag = true;
            for(int j = 0 ; j < N ; j++) {
                if(Math.abs(before - map[j][i]) > 1) {
                    flag = false;
                    break; // 길이가 2차이 이상 차이 남
                }
                // 커->작인경우, ->로 다리를 깔며 검사
                if(before - map[j][i] > 0) {
                    // L 횟수만큼 다리를 깐다.
                    int bCount = 0;
                    int bVal = map[j][i]; // 다리 설치 값
                    for(int k = j ; k < N && bCount != L ; k++) {
                        if(bridge[k] || bVal != map[j][i]) {
                            flag = false; // 이미 다리가 깔려있음
                            break;
                        }
                        bridge[k] = true; // 다리설치
                        bCount++;
                    }
                    if(bCount != L) { // 다리를 충분히 설치못함
                        flag = false;
                        break;
                    }
                } else if(before - map[j][i] < 0) {
                    // 작->커인경우 <- 로 다리를 깔며 검사
                    // L 횟수만큼 다리를 깐다.
                    int bCount = 0;
                    int bVal = map[j][i]; // 다리 설치 값
                    for(int k = j - 1 ; k >= 0 && bCount != L ; k--) {
                        if(bridge[k] || bVal != map[j][i]) {
                            flag = false; // 이미 다리가 깔려있음
                            break;
                        }
                        bridge[k] = true; // 다리설치
                        bCount++;
                    }
                    if(bCount != L) { // 다리를 충분히 설치못함
                        flag = false;
                        break;
                    }
                }
                before = map[j][i];
            }
            if(flag) {
                // 성공
                count++;
            }
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}

