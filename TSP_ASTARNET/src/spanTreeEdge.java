
public class spanTreeEdge {
	private int fromNode;
	private int toNode;
	private int cost;
	
	public spanTreeEdge(int fr, int to, int cost){
		this.fromNode = fr;
		this.toNode = to;
		this.cost = cost;
	}
	
	public int getCost(){
		return this.cost;
	}
	public int getFromNode(){
		return this.fromNode;
	}
	public int getToNode(){
		return this.toNode;
	}
}
