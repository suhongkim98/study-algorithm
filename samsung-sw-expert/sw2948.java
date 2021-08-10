
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int N = sc.nextInt();
		    int M = sc.nextInt();
		    HashMap<String, Integer> hash = new HashMap<>();
		    int count = 0;
		    for(int i = 0 ; i < N ; i++) {
		        String input = sc.next();
		        hash.put(input, i);
		    }
		    for(int i = 0 ; i < M ; i++) {
		        String input = sc.next();
		        if(hash.get(input) != null) {
		            count++;
		        }
		    }
		    System.out.println("#" + test_case+ " " + count);
		}
	}
}
