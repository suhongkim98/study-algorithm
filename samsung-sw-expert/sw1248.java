
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
public class Solution
{
   public static void main(String args[]) throws Exception
   {

      Scanner sc = new Scanner(System.in);
      int T;
      T=sc.nextInt();

      for(int test_case = 1; test_case <= T; test_case++)
      {
          int v = sc.nextInt();
          int e = sc.nextInt();
          int t1 = sc.nextInt();
          int t2 = sc.nextInt();
          Node[] nodes = new Node[v];
          for(int i = 0 ; i < v ; i++) {
              nodes[i] = new Node(i + 1);
          }
          for(int i = 0 ; i < e ; i++) {
              int p = sc.nextInt();
              int c = sc.nextInt();
              Node parent = nodes[p - 1];
              Node child = nodes[c - 1];
              child.parent = parent;
              if(parent.left == null) {
                  parent.left = child;
              } else {
                  parent.right = child;
              }
          }
          int target = t1;
          int count = 0;
          Stack<Node> s = new Stack<>();
          while(true) {
              int c = 0;
              s.push(nodes[target - 1]);
              while(!s.isEmpty()) {
                  Node node = s.pop();
                  if(node.value == t1 || node.value == t2) {
                      c++;
                  }
                  if(node.left != null) s.push(node.left);
                  if(node.right != null) s.push(node.right);
              }
              
              if(c >= 2) {
                  break;
              }
              target = nodes[target - 1].parent.value;
          }
          s.push(nodes[target - 1]);
          while(!s.isEmpty()) 
          {
              count++;
              Node node = s.pop();
              if(node.left != null) {
                  s.push(node.left);
                  
              }
              if(node.right != null) {
                  s.push(node.right);
                  
              }
              
          }
          System.out.println("#" + test_case + " " + nodes[target - 1].value + " " + count);
      }
   }
}
class Node {
    int value;
    Node parent;
    Node left;
    Node right;
    public Node(int v) {
        this.value = v;
    }
}
