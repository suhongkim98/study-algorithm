import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
	    
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int size = sc.nextInt();
		    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		    System.out.print("#" + test_case + " ");
		    for(int i = 0 ; i < size ; i++) {
		        int type = sc.nextInt();
		        if(type == 1) {
		            int val = sc.nextInt();
		            q.add(val);
		        } else {
		            Integer val = q.poll();
		            if(val == null) System.out.print(-1 + " ");
		            else System.out.print(val + " ");
		        }
		    }
		    System.out.println();
		}
	}
}
