import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Box box = new Box(str);
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("L")) box.moveLeft();
            if(input[0].equals("D")) box.moveRight();
            if(input[0].equals("B")) box.delete();
            if(input[0].equals("P")) box.insert(input[1].charAt(0));
        }
        bw.write(box + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
class Item {
    char c;
    Item left;
    Item right;
    public Item(char c) {
        this.c = c;
    }
}
class Box {
    Item cursor; // 커서. 마지막 문자의 다음 아이템을 가리킨다.
    Item end; // 끝아이템은 항상 \0이다.

    // abcd
    public Box(String input) {
        end = new Item('\0');
        cursor = end;
        for(int i = 0 ; i < input.length() ; i++) {
            char c = input.charAt(i);
            addLast(c);
        }
    }

    // 마지막 아이템의 앞에 문자를 추가한다.
    public void addLast(char c) {
        Item item = new Item(c);
        if(end.left == null) {
            item.right = end;
            end.left = item;
        } else {
            end.left.right = item;
            item.left = end.left;
            item.right = end;
            end.left = item;
        }
        cursor = end;
    }

    // 해당 커서의 앞 뒤 아이템 사이에 새로운 아이템을 추가
    public void insert(char c) {
        if(cursor == end) {
            addLast(c);
        } else {
            Item item = new Item(c);
            item.left = cursor.left;
            item.right = cursor;
            cursor.left = item;
            if(item.left != null)
                item.left.right = item;
        }
    }
    public void moveLeft() {
        if(cursor.left != null)
            cursor = cursor.left;
    }
    public void moveRight() {
        if(cursor.right != null)
            cursor = cursor.right;
    }

    // 커서의 앞 아이템 삭제
    public void delete() {
        if(cursor.left != null) {
            Item target = cursor.left;
            if(target.left == null) { // 타켓이 첫문자라면
                cursor.left = null; // 현재 커서의 왼쪽을 null 처리
            } else {
                target.left.right = target.right;
                target.right.left = target.left;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Item cur = cursor;
        // 맨 앞으로 이동
        while (cur.left != null) cur = cur.left;

        while(cur != end) {
            sb.append(cur.c);
            cur = cur.right;
        }
        return sb.toString();
    }
}
