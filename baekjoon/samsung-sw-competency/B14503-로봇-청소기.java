import java.awt.*;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];

        input = br.readLine().split(" ");
        Point start = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        int startDir = Integer.parseInt(input[2]); // 0: 북 1:동 2:남 3: 서

        for(int i = 0 ; i < map.length ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < map[0].length ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        Robot robot = new Robot(start, startDir);
        dfs(map, robot);


        bw.write(cleanCount + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static int cleanCount = 0;
    static void dfs(int[][] map, Robot robot) {
        // 현재 위치를 청소한다.
        map[robot.curPoint.x][robot.curPoint.y] = 2;
        cleanCount++;
        //print(map);
        // 왼쪽 방향부터 차례대로 탐색 진행
        int turnCount = 0; // 회전횟수
        boolean find = false;
        while (true) {
            if(turnCount > 3) {
                // 4방면 다 시도했음
                // 4방면 다 시도했다면 후진시도 후 continue
                // 후진 불가능하면 작동종료
                if(robot.dir == 0) {
                    if(map[robot.curPoint.x + 1][robot.curPoint.y] == 1) break;
                    else {
                        robot.curPoint.x += 1;
                        turnCount = 0; // turnCount 초기화
                    }

                } else if(robot.dir == 1) {
                    if(map[robot.curPoint.x][robot.curPoint.y - 1] == 1) break;
                    else {
                        robot.curPoint.y -= 1;
                        turnCount = 0; // turnCount 초기화
                    }

                } else if(robot.dir == 2) {
                    if(map[robot.curPoint.x - 1][robot.curPoint.y] == 1) break;
                    else {
                        robot.curPoint.x -= 1;
                        turnCount = 0; // turnCount 초기화
                    }

                } else {
                    if(map[robot.curPoint.x][robot.curPoint.y + 1] == 1) break;
                    else {
                        robot.curPoint.y += 1;
                        turnCount = 0; // turnCount 초기화
                    }

                }
            }
            turnCount++;
            // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면 그 방향으로 회전한 다음 한 칸을 전진하고 break
            // 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 continue
            if(robot.dir == 0) {
                if(map[robot.curPoint.x][robot.curPoint.y - 1] == 0) {
                    find = true;
                    robot.dir = 3;
                    robot.curPoint.y -= 1;
                    break;
                } else {
                    robot.dir = 3;
                }
            } else if(robot.dir == 1) {
                if(map[robot.curPoint.x - 1][robot.curPoint.y] == 0) {
                    find = true;
                    robot.dir = 0;
                    robot.curPoint.x -= 1;
                    break;
                } else {
                    robot.dir = 0;
                }
            } else if(robot.dir == 2) {
                if(map[robot.curPoint.x][robot.curPoint.y + 1] == 0) {
                    find = true;
                    robot.dir = 1;
                    robot.curPoint.y += 1;
                    break;
                } else {
                    robot.dir = 1;
                }
            } else {
                if(map[robot.curPoint.x + 1][robot.curPoint.y] == 0) {
                    find = true;
                    robot.dir = 2;
                    robot.curPoint.x += 1;
                    break;
                } else {
                    robot.dir = 2;
                }
            }
        }
        if(find) dfs(map, robot); // 새로히 청소구역을 찾음
    }
    static void print(int[][] map) {
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[0].length ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
/*
map 값이 0: 청소 가능 1: 벽 2: 청소된구역

 */
class Robot {
    Point curPoint;
    int dir;
    public Robot(Point curPoint, int dir) {
        this.curPoint = curPoint;
        this.dir = dir;
    }
}

