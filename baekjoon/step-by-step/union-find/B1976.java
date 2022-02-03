import java.io.*;
import java.util.*;

//유니온파인드 활용문제
//가고자 하는 여행지가 같은 집합에 속해있는 지 확인
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] parent = new int[N];
        UnionFind.init(parent);

        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                int isConnect = Integer.parseInt(input[j]);
                if(isConnect == 1) {
                    UnionFind.unionSet(parent, i, j);
                }
            }
        }
        String[] input = br.readLine().split(" ");
        boolean bool = true;
        int set = UnionFind.findSet(parent, Integer.parseInt(input[0]) - 1); // 가고자하는 여행지 집합이 모두 일치해야한다.
        for(int i = 0 ; i < M ; i++) {
            if(set != UnionFind.findSet(parent, Integer.parseInt(input[i]) - 1)) {
                bool = false;
                break;
            }
        }
        if(bool) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        br.close();
        bw.close();
    }
}
class UnionFind {

    //일반적으로 makeSet을 구현하지 않고 반복문으로 초기화
    static void init(int[] parent) {
        for(int i = 0 ; i < parent.length ; i++) {
            parent[i] = -1;
        }
    }
    static int findSet(int[] parent, int v) {
        // 음수인경우 해당 음수값은 사이즈 * -1을 의미하고 v는 대표원소임을 의미
        if(parent[v] < 0) return v;
        // return findSet(parent, parent[v]); //경로압축X
        return parent[v] = findSet(parent, parent[v]); // 경로압축O 시간초과시 사용
    }
    //v가 속한 집합의 대표원소를 찾아 -1을 곱해 사이즈 반환
    static int getSetSize(int[] parent, int v) {
        return -parent[findSet(parent, v)];
    }
    static void unionSet(int[] parent, int u, int v) {
        int root1 = findSet(parent, u);
        int root2 = findSet(parent, v);
        if(root1 == root2) return; // 대표원소가 같다는 의미는 같은 집합에 있다는 의미로 합집합할 필요 없음
        parent[root1] += parent[root2]; //원소의 개수를 더해줌
        parent[root2] = root1;
    }
}
