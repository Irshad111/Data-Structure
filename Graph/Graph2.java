package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph2 {
	int V;
	LinkedList<Integer> adjListArray[];
	Graph2(int v){
		this.V=v;
		adjListArray=new LinkedList[v];
		for(int i=0;i<v;i++) {
			adjListArray[i]=new LinkedList<>();
		}
		
	}
	public void addEdge(int src,int dest) {
		// add edge src to destination
		adjListArray[src].add(dest);
		// add edge dest to src
		adjListArray[dest].add(src);
		
	}
	public void display() {
		System.out.println("-----------------");
		for(int i=0;i<V;i++) {
			    System.out.print("Adjacency of vertex "+i +" is ");
			for(Integer nbr:adjListArray[i]) {
				System.out.print("->"+nbr);
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}
/*Complete the function below*/
/*
ArrayList<ArrayList<>Integer>list: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort
{
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
       // add your code here
       Stack<Integer> stack=new Stack();
       boolean []visited=new boolean[N];
       for(int v=0;v<N;v++){
           if(!visited[v]){
               helper(list,v,visited,stack);
           }
           
       }
       int output[]=new int[N];
       int i=0;
       for(Integer a:stack){
           output[i++]=a;
       }
       return output;
       
       
       
    }
    static void helper(ArrayList<ArrayList<Integer>> list ,int n,boolean []visited,Stack<Integer> stack){
            visited[n]=true;
           ArrayList<Integer> children=list.get(n);
           for(Integer child:children){
               if(!visited[child]){
                   helper(list,child,visited,stack);
                   
               }
           }
           stack.push(n);
    }
}

