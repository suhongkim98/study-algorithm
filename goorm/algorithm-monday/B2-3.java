import java.awt.*;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Person[] persons = new Person[N];
        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            persons[i] = new Person(input[0], Float.parseFloat(input[1]));
        }
        Arrays.sort(persons, (e1, e2)-> {
            if(e1.name.equals(e2.name)) {
                return Float.compare(e1.height, e2.height);
            }
            return e1.name.compareTo(e2.name);
        });
        bw.write(persons[K - 1].name + " " + String.format("%.2f", persons[K - 1].height) + "\n");

        br.close();
        bw.close();
    }
}

class Person {
    String name;
    float height;
    public Person(String name, float height) {
        this.name = name;
        this.height = height;
    }
}

/*


 */
