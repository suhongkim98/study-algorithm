import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        CustomQueue q = new CustomQueue();
        for(int i = 0 ; i < n ; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("push")) {
                q.push(Integer.parseInt(input[1]));
            }
            if(input[0].equals("pop")) {
                bw.write(q.pop() + "\n");
            }
            if(input[0].equals("front")) {
                bw.write(q.getFront() + "\n");
            }
            if(input[0].equals("back")) {
                bw.write(q.getBack() + "\n");
            }
            if(input[0].equals("size")) {
                bw.write(q.size + "\n");
            }
            if(input[0].equals("empty")) {
                bw.write(q.isEmpty() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Data {
    int value;
    Data next;
    public Data(int n) {
        value = n;
    }
}

class CustomQueue {
    Data start;
    Data end;
    int size;

    public void push(int n) {
        size++;
        Data data = new Data(n);
        if(start == null) {
            start = data;
        }
        if(end != null) {
            end.next = data;
        }
        end = data;
    }
    public int pop() {
        if(size <= 0) return -1;
        Data data = start;
        start = start.next;
        --size;
        if(size <= 0) {
            start = null;
            end = null;
        }
        return data.value;
    }

    public int isEmpty() {
        if(size == 0) return 1;
        return 0;
    }

    public int getFront() {
        if(start == null) return -1;
        return start.value;
    }
    public int getBack() {
        if(end == null) return -1;
        return end.value;
    }
}
