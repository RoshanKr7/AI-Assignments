import java.util.*;


public class AstarAlgo {
	private int[] path;
	private int visit[];
	private int costNow;
	private PriorityQueue<searchNode> open;
	private Comparator<searchNode> comptor;
		
	public AstarAlgo(int [][] cost, int no_City, int start){
		path = new int[no_City];
		visit = new int[no_City];
		for(int i = 0; i < no_City; i++){
			this.visit[i] = 0;
		}
		
		comptor = new costComparator();
		open = new PriorityQueue<searchNode>(no_City, comptor);
		
		this.sol(cost, no_City, start);
	}
	
	private void sol(int [][] cost, int no_City, int start){
		int no_Visited = 1;
		int current = start;
		visit[current] = no_Visited++;
		while(no_Visited <= no_City){
			for(int i = 0; i < no_City; i++){
				if(i != current && cost[current][i] < Integer.MAX_VALUE){
					if(visit[i] == 0){				//i.e. Not visited city
						minSpanTree tempSpanTree = new minSpanTree(cost, visit, no_City);
						int hCost = tempSpanTree.getTotalCost();
						//System.out.println(i + "  " + hCost);
						searchNode tempSearchNode = new searchNode(i, (hCost + cost[current][i]) );
						open.add(tempSearchNode);
					}
				}
			}
			current = open.poll().cityId;
			visit[current] = no_Visited++;
		}
		this.calPath(cost);
	}
	
	private void calPath(int cost[][]){
		for(int i = 1; i <= this.visit.length; i++){
			for(int j = 0; j < this.visit.length; j++)
				if(visit[j] == i){
					this.path[i-1] = j + 1;
				}
		}
		long tempTCost = 0;
		for(int i = 0; i < this.visit.length-1; i++){
			tempTCost += cost[path[i]-1][path[i+1]-1];
		}
		if(tempTCost > Integer.MAX_VALUE)
			costNow = Integer.MAX_VALUE;
		else
			costNow = (int) tempTCost;
		//System.out.println("\n");
		//for(int i = 0; i < this.visited.length; i++){
		//	System.out.print(i + "(" + visited[i] + ")");
		//}
	}
	public void printPath(){
		for(int i = 0; i < this.path.length; i++){
			System.out.print(path[i] + " ");
		}
		System.out.print('1');
		System.out.println();
		//System.out.print("Cost = " + this.costNow);
	}
}
