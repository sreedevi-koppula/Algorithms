import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class ConnectedComponents {
	//Problem statement is provided at the end of this program
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>(); //This is used for making a DFS traversal of graph starting from first vertex of present in the graph's adjacency list
        int[] visited = new int[adj.length]; //This is used for maintaining the list of visited vertices
        for(int i=0;i<visited.length;i++) visited[i]=-1; //Initialising the array of visited elements to '-1' 
		int x=0,numOfEle = 0,j=0;
		while(numOfEle<=adj.length){	
			//if stack is empty, the value of next unvisited vertex of the graph is calculated.
			//if the value is '-1', it means that there is no more unvisited vertex and we exit from the 'while' loop
			if(stack.isEmpty()){
				x=-1;
				for(int i=0;i<adj.length;i++){
					final int s = i;
					if(!IntStream.of(visited).anyMatch(a -> a == s)){
						x=s;
						stack.push(x);
						visited[j++] = x;
						numOfEle++;
						break;
					}	
				}
				if(x==-1)
					break;
			}	
			//if the stack is not empty (or) if there is any unvisited vertex of the graph,
			//we fetch the details of the adjacent vertices of unvisited vertex 'x' 
			//and mark those adjacent vertices as visited and push them to stack
			for(int k:adj[x]){
				if(!IntStream.of(visited).anyMatch(a -> a == k)){
					stack.push(k);
					visited[j++] = k;
					numOfEle++;
				}
			}
			
			//Stack is popped here and we check if it is empty
			x=stack.pop();
			//if the stack is empty, then we reached the end of a connected component
			//Hence we increment the count of the connected components 'result' by 1
			if(stack.isEmpty())
				result++;
		}
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
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
        System.out.println(numberOfComponents(adj));
    }
}
/***************************************************************************************
 Problem: Adding Exits to a Maze
Problem Introduction
Now you decide to make sure that there are no dead zones in a maze, that is, that at least one exit is
reachable from each cell. For this, you nd connected components of the corresponding undirected graph
and ensure that each component contains an exit cell.
Problem Description
Task. Given an undirected graph with n vertices and m edges, compute the number of connected components
in it.
Input Format. A graph is given in the standard format.
Constraints. 1<=n<=10power(3), 0<=m<=10power(3).
Output Format. Output the number of connected components.
Time Limits. C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript:
5 sec, Ruby: 5 sec, Scala: 3 sec.
Memory Limit. 512Mb.
Sample 1.
Input:
4 2
1 2
3 2
Output:
2
Explanation:
1 2
4 3
There are two connected components here: f1; 2; 3g and f4g.
Starter Files
The starter solutions for this problem read the input data from the standard input, pass it to a blank
procedure, and then write the result to the standard output. You are supposed to implement your algorithm
in this blank procedure if you are using C++, Java, or Python3. For other programming languages, you need
to implement a solution from scratch.
What To Do
To solve this problem, it is enough to implement carefully the corresponding algorithm covered in the
lectures.
 **************************************************************************************/
 

