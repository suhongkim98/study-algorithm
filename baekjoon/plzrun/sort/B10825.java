import java.io.*;
import java.util.*;

// 우선순위큐를 이용하여 조건에 따라 정렬
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> {
            int koreanDiff = p1.korean - p2.korean;
            if(koreanDiff == 0) {
                int englishDiff = p1.english - p2.english;
                if(englishDiff == 0) {
                    int mathDiff = p1.math - p2.math;
                    if(mathDiff == 0) {
                        return p1.name.compareTo(p2.name);
                    }
                    return -mathDiff;
                }
                return englishDiff;
            }
            return -koreanDiff;
        });
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            pq.add(new Person(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
        }
        while (!pq.isEmpty()) {
            Person person = pq.poll();
            bw.write(person.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Person {
    String name;
    int korean;
    int english;
    int math;
    public Person(String name,int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}
