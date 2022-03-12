import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testcase ; i++) {
            int f = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>(); // 이름, idx
            int[] parent = new int[f * 2 + 1]; // 이름 경우의 수 최대값
            int startIdx = 0;
            UnionFindV2.init(parent);            
            for(int j = 0 ; j < f ; j++) {
                String[] input = br.readLine().split(" ");
                if(map.get(input[0]) == null) {
                    // 처음 거론된 이름
                    map.put(input[0], startIdx++);
                }
                if(map.get(input[1]) == null) {
                    // 처음 거론된 이름
                    map.put(input[1], startIdx++);
                }
                UnionFindV2.unionSet(parent, map.get(input[0]), map.get(input[1]));

                bw.write(UnionFindV2.getSetSize(parent, map.get(input[0])) + "\n");
            }
        }

        bw.close();
        br.close();
    }

}
//집합의 크기를 알 수 있도록한 유니온파인드
//유니온파인드 자료구조에서 root에 해당하는 각 대표 원소가 parent link로 자신을 가리키지 않고 집합의 크기를 갖도록 한다.
class UnionFindV2 {

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
    // parent 배열 통해 해당 그래프에서 집합의 개수 구하기 // bfs 응용
    static int getSetCount(int[] parent) { // 집합의 개수 반환
        boolean[] visit = new boolean[parent.length];
        int count = 0;
        for(int i = 0 ; i < parent.length ; i++) {
            int myParent = UnionFindV2.findSet(parent, i); // 해당 원소가 속한 집합의 대표 원소 반환
            if(!visit[myParent]) { // 해당 대표원소를 방문한 적 없다면 카운트하지 않은 집합임
                count++;
                visit[myParent] = true;
            }
        }
        return count;
    }
}
