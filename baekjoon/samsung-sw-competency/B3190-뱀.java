import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

/*
뱀은 맨 왼쪽 위에 위치, 길이는 1
처음에는 오른쪽으로 이동
이동 방식
맵의 벽이나 자기 꼬리에 부딫히면 종료
* 먼저 이동하고자 하는 방향으로 몸이 늘어남 // 이때 충돌검사해야 함
* 그 위치에 사과가 있으면 그대로
* 그 위치에 사과가 없으면 꼬리가 줄어듦, 즉 길이유지

이동 다했음에도 충돌이 나지 않은 경우엔 진행방향으로 계속 이동해주어야 함
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N + 1][N + 1]; // 시작 1 A: 사과

        int APPLE = Integer.parseInt(br.readLine());
        for (int i = 0; i < APPLE; i++) {
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 'A';
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Move> q = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            char C = input[1].charAt(0);
            q.add(new Move(X, C));
        }

        int count = 0;
        Worm w = new Worm(new Point(1, 1));
        boolean isCollision = false;

        while (!q.isEmpty()) {
            Move m = q.poll();

            while (count < m.x) {
                Point newPos = new Point(w.head.point.x, w.head.point.y);
                count++;
                if(w.dir == 'N') {
                    newPos.x -= 1;
                } else if(w.dir == 'E') {
                    newPos.y += 1;
                } else if(w.dir == 'S') {
                    newPos.x += 1;
                } else if(w.dir == 'L') {
                    newPos.y -= 1;
                }
                // 맵 충돌 검사

                if(w.move(map, newPos) == false) {
                    // 충돌 남
                    isCollision = true;
                    break;
                }
            }

            if(isCollision) {
                break;
            }

            // x초에 도달했다면 이후에 방향을 전환한다.
            if(m.dir == 'L') {
                // 좌측으로 틀어라
                if(w.dir == 'N') {
                    w.dir = 'L';
                } else if(w.dir == 'E') {
                    w.dir = 'N';
                } else if(w.dir == 'S') {
                    w.dir = 'E';
                } else if(w.dir == 'L') {
                    w.dir = 'S';
                }
            } else if(m.dir == 'D') {
                // 우측으로 틀어라
                if(w.dir == 'N') {
                    w.dir = 'E';
                } else if(w.dir == 'E') {
                    w.dir = 'S';
                } else if(w.dir == 'S') {
                    w.dir = 'L';
                } else if(w.dir == 'L') {
                    w.dir = 'N';
                }
            }
        }
        // 충돌이 아직도 안났다면 진행방향으로 충돌 날 때까지 이동
        while (!isCollision) {
            Point newPos = new Point(w.head.point.x, w.head.point.y);
            count++;
            if(w.dir == 'N') {
                newPos.x -= 1;
            } else if(w.dir == 'E') {
                newPos.y += 1;
            } else if(w.dir == 'S') {
                newPos.x += 1;
            } else if(w.dir == 'L') {
                newPos.y -= 1;
            }
            if(w.move(map, newPos) == false) {
                // 이동하다 충돌 남
                break;
            }
        }
        //
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
class Worm {
    WormBody head;
    WormBody tail;
    char dir; // N, E, S, L // 북 동 남 서
    public Worm(Point pos) {
        this.dir = 'E'; // 기본은 서쪽으로 향함
        head = new WormBody(pos);
        head.next = null;
        tail = head;
    }

    public boolean move(char[][] map, Point point) {
        if(point.x > map.length - 1 || point.x < 1) return false; // 맵충돌
        if(point.y > map.length - 1 || point.y < 1) return false; // 맵 충돌

        // 몸을 늘린다.
        WormBody newWormBody = new WormBody(point);
        this.head.next = newWormBody;
        this.head = newWormBody;
        // 충돌하는지 확인
        if(isCollision()) return false; // 이동 실패
        if(map[point.x][point.y] == 'A') {
            // 음식이 있다면
            map[point.x][point.y] = ' ';
        } else {
            // 몸을 줄인다.
            this.tail = this.tail.next;
        }
        return true;
    }
    public boolean isCollision() {
        // tail 부터 head 까지 탐색하며 충돌검사
        // head 가 다른거랑 부딫히는지 검사
        WormBody cur = tail;
        while (cur != head) {
            if(cur.point.x == this.head.point.x && cur.point.y == this.head.point.y) return true;
            cur = cur.next;
        }
        return false;
    }
}
class WormBody {
    Point point;
    WormBody next;
    public WormBody(Point point) {
        this.point = point;
    }
}

class Move {
    int x;
    char dir;
    public Move(int x, char c) {
        this.x = x;
        this.dir = c;
    }
}


