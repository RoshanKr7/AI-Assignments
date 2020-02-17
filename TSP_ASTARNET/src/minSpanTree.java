import java.util.*;


public class minSpanTree {
	private ArrayList<spanTreeEdge> tree;
	private Comparator<spanTreeEdge> comptor;
	private PriorityQueue<spanTreeEdge> q;
	
	public minSpanTree(int [][] cost, int visit[], int no_City){
		tree = new ArrayList<spanTreeEdge>();
		comptor = new distComparator();
		q = new PriorityQueue<spanTreeEdge>(no_City, comptor);
		
		for(int i = 0; i < no_City; i++){								
			for(int j = i + 1; j < no_City; j++){
				if(visit[i] == 0 && visit[j] == 0){
					spanTreeEdge tempEdge = new spanTreeEdge(i, j, cost[i][j]);
					q.add(tempEdge);
				} 
			}
		}
		for(int i = 0, tempNum = no_City; i < tempNum; i++){
			if(visit[i] > 0)
				no_City--;
		}
		this.calMinSpanTree(cost, no_City);
	}
	
	private void calMinSpanTree(int [][] cost, int no_City){
		spanTreeEdge tempEdge;
		int i = 0;
		while((tempEdge = q.poll()) != null  && i < no_City-1){
			//System.out.println(tempEdge.getFromNode() + "->" + tempEdge.getToNode() + "(" + tempEdge.getCost()+")"); //
			if( !this.isCycle(tempEdge)){
				tree.add(tempEdge);
				i++;
			}
		}
	}
	
	private boolean isCycle(spanTreeEdge newEdge){
		boolean node1Match, node2Match;
		node1Match = node2Match = false;
		Iterator<spanTreeEdge> navi = this.tree.iterator();
		while(navi.hasNext()){
			spanTreeEdge tempEdge = navi.next();
			if(!node1Match && (newEdge.getFromNode() == tempEdge.getFromNode() || newEdge.getFromNode() == tempEdge.getToNode())){
				node1Match = true;
			}
			if(!node2Match && (newEdge.getToNode() == tempEdge.getFromNode() || newEdge.getToNode() == tempEdge.getToNode())){
				node2Match = true;
			}
		}
		if(node1Match && node2Match)
			return true;
		else
			return false;
	}
	
	public int getTotalCost(){
		int totalCost = 0;
		Iterator<spanTreeEdge> gts = this.tree.iterator();
		while(gts.hasNext()){
			spanTreeEdge tempEdge = gts.next();
			totalCost += tempEdge.getCost();
		//	System.out.println(tempEdge.getFromNode() + "->" + tempEdge.getToNode() + "(" + tempEdge.getCost() + ")" + "(" + totalCost + ")"); //
		}
		return totalCost;
	}
}