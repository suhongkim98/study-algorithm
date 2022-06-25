import java.io.*;
import java.util.*;

// 이분그래프 문제
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<ArrayList<Integer>> adjList;
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase ; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            adjList = new ArrayList<>();
            for(int adjIndex = 0 ; adjIndex < V + 1 ; adjIndex++) {
                adjList.add(new ArrayList<>());
            }
            for(int j = 0 ; j < E ; j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                adjList.get(a).add(b);
                adjList.get(b).add(a);
            }

            // 방문안한 노드를 검색해서 BFS 시작, 시작노드는 T부여하고 BFS 돌며 현재와 반대를 할당. 근데 할당해야하는 것과 대상의 bit 가 다르다면 이분그래프가 아님
            // 현재노드와 일치한경우 NO 출력
            Boolean[] bit = new Boolean[V + 1]; // 이분그래프 여부를 위한 변수 선언, node 시작은 1, (null=할당안된 상태, true: T false: F 할당)
            boolean[] visit = new boolean[V + 1]; // 노드 방문 여부
            boolean checkBipartite = false; // 이분그래프가 아니라면 true 할당

            // 노드를 탐색한다.
            for(int node = 1 ; node < V + 1 ; node++) {
                Queue<Integer> q = new LinkedList<>();
                // 해당 노드를 방문한 적 없다면 T 할당하고 bfs 시작
                if(!visit[node]) {
                    visit[node] = true; // bfs 시작 노드
                    q.add(node);
                    bit[node] = true;
                }
                while (!q.isEmpty() && !checkBipartite) { // 아직까지 이분 그래프이면서 큐가 비지 않았다면
                    int cur = q.poll();

                    // 인접노드에게는 cur의 반대를 할당해주어야 한다.
                    // 그런데 이미 할당이 되어있는 상태에서 할당해주어야하는 bit와 다르다면 이분그래프가 아니다.
                    for(int k = 0 ; k < adjList.get(cur).size() ; k++) {
                        int target = adjList.get(cur).get(k);
                        if(bit[target] == null) { // 인접노드인데 bit 할당이 되어있지 않다면
                            bit[target] = !bit[cur]; // 현재의 반대를 할당
                        } else if(bit[cur] == bit[target]) { // 이미 할당이 되어있다면 조건문 비교
                            checkBipartite = true; // 이분그래프가 아니네
                        }
                        if(!visit[target]) {
                            visit[target] = true;
                            q.add(target); // 큐삽입
                        }
                    }
                }
            }
            if(checkBipartite) bw.write("NO\n");
            else bw.write("YES\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

