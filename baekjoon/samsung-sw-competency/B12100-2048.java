import java.util.*;
import java.io.*;

/*
시뮬레이션, 백드래킹
현재 맵 저장 후 위 오른쪽 아래 왼쪽 순으로 백트래킹 돌리고 맵 복구하는 형태
5번 이내로 돌린 후 최대값을 갱신

오른쪽으로 이동 시에는 오른쪽 요소부터 오른쪽으로 이동
위로 이동 시에는 위에 있는 요소부터 이동
처럼 방향성 있는 요소부터 움직여야 함

한번 이동 시 이미 합쳐진 것은 또 합쳐지지않음이 포인트
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        solve(1);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static int[][] map;
    static int result = -1;
    static void solve(int count) { // dir: 0,1,2,3  위 오른쪽 아래 왼쪽 순 이동
        if(count > 5) {
            // 5회 다 돌게 될경우 map 상태봐서 최대값 갱신
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = 0 ; j < map[0].length ; j++) {
                    if(map[i][j] > result) result = map[i][j];
                }
            }
            return;
        }
        // 현재 맵 상태 저장
        int[][] tmp = new int[map.length][map[0].length];
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[0].length ; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        for(int newDir = 0 ; newDir < 4 ; newDir++) {
            // 4방면으로 백트래킹 들어가고 다시 되돌리기
            shift(map, newDir); // 이동시키기
            solve(count + 1);

            // 다시 되돌리기
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = 0 ; j < map[0].length ; j++) {
                    map[i][j] = tmp[i][j];
                }
            }
        }

    }
    static void shift(int[][] map, int dir) {
        // dir 방향대로 이동시킨다. 큐를 활용, 큐에 숫자를 다 집어넣고 차례대로 넣는 방법으로 shift, 이미 합쳐진 것은 또 합쳐지지 않는 것이 포인트
        Queue<Integer> q = new LinkedList<>();
        if(dir == 0) { // 위
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = 0 ; j < map.length ; j++) {
                    if(map[j][i] != 0) {
                        q.add(map[j][i]);
                        map[j][i] = 0;
                    }
                }

                // 하나씩 꺼내며 연산
                int idx = 0; // 시작 인덱스
                while (!q.isEmpty()) {
                    int n = q.poll();
                    if(map[idx][i] == 0) {
                        map[idx][i] = n;
                    } else if(map[idx][i] == n) {
                        map[idx][i] += n;
                        idx++;
                    } else {
                        // 일치하지 않으면 다음 요소에 배치
                        map[++idx][i] = n;
                    }
                }
            }
        }

        if(dir == 1) { // 오른쪽
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = map.length - 1 ; j >= 0 ; j--) {
                    if(map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                // 하나씩 꺼내며 연산
                int idx = map.length - 1; // 시작 인덱스
                while (!q.isEmpty()) {
                    int n = q.poll();
                    if(map[i][idx] == 0) {
                        map[i][idx] = n;
                    } else if(map[i][idx] == n) {
                        map[i][idx] += n;
                        idx--;
                    } else {
                        // 일치하지 않으면 다음 요소에 배치
                        map[i][--idx] = n;
                    }
                }
            }
        }
        if(dir == 2) { // 아래
            for(int i = 0 ; i < map.length ; i++) {
                for(int j = map.length - 1 ; j >= 0 ; j--) {
                    if(map[j][i] != 0) {
                        q.add(map[j][i]);
                        map[j][i] = 0;
                    }
                }

                // 하나씩 꺼내며 연산
                int idx = map.length - 1; // 시작 인덱스
                while (!q.isEmpty()) {
                    int n = q.poll();
                    if(map[idx][i] == 0) {
                        map[idx][i] = n;
                    } else if(map[idx][i] == n) {
                        map[idx][i] += n;
                        idx--;
                    } else {
                        // 일치하지 않으면 다음 요소에 배치
                        map[--idx][i] = n;
                    }
                }
            }
        }
        if(dir == 3) { // 왼쪽
            for(int i = 0 ; i < map.length  ; i++) {
                for(int j = 0 ; j < map.length ; j++) {
                    if(map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                // 하나씩 꺼내며 연산
                int idx = 0; // 시작 인덱스
                while (!q.isEmpty()) {
                    int n = q.poll();
                    if(map[i][idx] == 0) {
                        map[i][idx] = n;
                    } else if(map[i][idx] == n) {
                        map[i][idx] += n;
                        idx++;
                    } else {
                        // 일치하지 않으면 다음 요소에 배치
                        map[i][++idx] = n;
                    }
                }
            }
        }
    }
}


