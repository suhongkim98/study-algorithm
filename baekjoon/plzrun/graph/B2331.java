import java.util.*;
import java.io.*;

class Main {
    static Map<Integer, Integer> map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new HashMap<>();
        String[] input = br.readLine().split(" ");

        map.put(Integer.parseInt(input[0]), count++);
        System.out.println(dfs(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        bw.flush();
        bw.close();
        br.close();
    }
    static int dfs(int n, int p) { // 깊이 반환
        int target = n;
        int result = 0;
        while (target > 0) {
            result += Math.pow(target % 10, p);
            target = target / 10;
        }
        if(map.get(result) != null) {
            return map.get(result);
        }
        map.put(result, count++);
        return dfs(result, p);
    }
}

