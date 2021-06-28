import java.util.*;
//https://www.acmicpc.net/problem/2941
public class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] list = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i = 0 ; i < list.length ; i++) {
            input = input.replace(list[i], "X");
        }
        System.out.println(input.length());
        scanner.close();
    }
}
