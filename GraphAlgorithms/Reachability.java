import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Reachability {
	//Problem statement is at the end of this program
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        if(adj[x].contains(y))
			return 1;
        else {
        	Stack<Integer> stack = new Stack<Integer>(); //This is used for making a DFS traversal of graph starting from vertex 'x'
        	int visited[] = new int[adj.length]; //This is used for maintaining the list of visited vertices
        	stack.push(x);
        	visited[0] = x;
        	int j=1;
        	while(!stack.isEmpty()){		
        		for(int i:adj[x]){
        			//Checking if the node 'i' is already present in the array 'visited'
        			//If node 'i' doesn't exist in 'visited' array, it is added to 'visited' array and pushed to the stack
        			if(!IntStream.of(visited).anyMatch(a -> a == i)){
        				stack.push(i);
                		visited[j++] = i;
        			}	
            	}
        		x = stack.pop();
        		if(adj[x].contains(y))
        			return 1;
        	}	
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Reading the number of vertices and edges
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //Creating an adjacency list of the given input graph
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        scanner.close();
        //'reach' method includes the code to see if there exists a path between the vertices 'x' , 'y'
        System.out.println(reach(adj, x, y));
    }
}

/**********************************************************
 * Problem Description
Task. Given an undirected graph and two distinct vertices u and v, check if there is a path between u and v.
Input Format. An undirected graph with n vertices and m edges. The next line contains two vertices u
and v of the graph.
Constraints. 1<=n,m<=10power(3); 1<=u,v<=n; u not equal to v.
Output Format. Output 1 if there is a path between u and v and 0 otherwise.
Time Limits. C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript:
5 sec, Ruby: 5 sec, Scala: 3 sec.
Memory Limit. 512Mb.
Sample 1.
Input:
4 4
1 2
3 2
4 3
1 4
1 4
Output:
1
Explanation:
1 2
4 3
In this graph, there are two paths between vertices 1 and 4: 1-4 and 1-2-3-4.
Sample 2.
Input:
4 2
1 2
3 2
1 4
4
Output:
0
Explanation:
1 2
4 3
In this case, there is no path from 1 to 4.
 *********************************************************/
